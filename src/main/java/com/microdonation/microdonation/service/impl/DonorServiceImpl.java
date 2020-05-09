package com.microdonation.microdonation.service.impl;

import com.microdonation.microdonation.exception.AppException;
import com.microdonation.microdonation.model.*;
import com.microdonation.microdonation.payload.*;
import com.microdonation.microdonation.repository.*;
import com.microdonation.microdonation.service.DonorService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.*;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    DonorRepository donorRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    DonorPymtFreqRepository donorPymtFreqRepository;

    @Autowired
    NgoRepository ngoRepository;

    @Autowired
    MyNgoRepository myNgoRepository;

    @Autowired
    DonorReferenceRepository donorReferenceRepository;

    public boolean saveDonorFrequency(DonorNGoPymtFreqRequest donorNGoPymtFreqRequest){
        Optional<User> userObj = userRepository.findById(donorNGoPymtFreqRequest.getUserId());
        try{
            User user = userObj.get();
            MdpDonor mdpDonor = getDonorFromUser(user);

            donorNGoPymtFreqRequest.getDonorFrequency().forEach(frequency -> {

                DonorNGoMapping  donorNGoMapping = new DonorNGoMapping(mdpDonor.getiDonorId(),frequency.getNgoId());
                TmdpDonorRecurPmtSetup tmdpDonorRecurPmtSetup = getDonorPymtFreqSetup(donorNGoMapping);
                if(tmdpDonorRecurPmtSetup == null) {
                    tmdpDonorRecurPmtSetup = new TmdpDonorRecurPmtSetup();
                    tmdpDonorRecurPmtSetup.setDonorNGoMapping(donorNGoMapping);
                    tmdpDonorRecurPmtSetup.setiCycleDay(frequency.getPaymentDay());
                    tmdpDonorRecurPmtSetup.setSzPaymentGetwayCode(frequency.getPaymentGatewayCode());
                    tmdpDonorRecurPmtSetup.setDtCreated(new Date());
                    tmdpDonorRecurPmtSetup.setfAmount(frequency.getAmount());
                    tmdpDonorRecurPmtSetup.setSzPmtFreq(frequency.getPaymentFrequency());
                }
                else
                {
                    tmdpDonorRecurPmtSetup.setiCycleDay(frequency.getPaymentDay());
                    tmdpDonorRecurPmtSetup.setSzPaymentGetwayCode(frequency.getPaymentGatewayCode());
                    tmdpDonorRecurPmtSetup.setfAmount(frequency.getAmount());
                    tmdpDonorRecurPmtSetup.setSzPmtFreq(frequency.getPaymentFrequency());
                }
                donorPymtFreqRepository.saveAndFlush(tmdpDonorRecurPmtSetup);
            });
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new AppException("Frequency Update Failed");
        }
    }

    public void createDonorDetails(MdpDonorDetails mdpDonorDetails)
    {
        try {
            MdpDonor mdpDonor = new MdpDonor();
            mdpDonor.setUser(mdpDonorDetails.getUser());
            mdpDonor.setSzDonorName(mdpDonorDetails.getDonorName());
            mdpDonor.setSzEmail(mdpDonorDetails.getEmail());
            mdpDonor.setSzMobile(mdpDonorDetails.getMobile());
            mdpDonor.setDtCreatedDate(new Date());
            donorRepository.saveAndFlush(mdpDonor);
        }catch (Exception e)
        {
            throw  new AppException("Ngo Data Save Failed");
        }
    }


    public  MdpDonor getDonorFromUser(User user)
    {
        MdpDonor mdpDonor = donorRepository.findByUser(user);
        return mdpDonor;
    }

    public boolean saveOrUpdateMyNgo(MyNgoRequest myNgoRequest){
        Optional<User> userObj = userRepository.findById(myNgoRequest.getUserId());
        try{
            User user = userObj.get();
            MdpDonor mdpDonor = getDonorFromUser(user);

            myNgoRequest.getNgoDetails().forEach(myNgo ->{
                DonorNGoMapping  donorNGoMapping = new DonorNGoMapping(mdpDonor.getiDonorId(), myNgo.getNgoId());
                TmdpMyNgo tmdpMyNgo = getMyNgoByDonor(donorNGoMapping);
                if(tmdpMyNgo == null)
                {
                    tmdpMyNgo = new TmdpMyNgo();
                    tmdpMyNgo.setDonorNGoMapping(donorNGoMapping);
                    tmdpMyNgo.setfRecurPmtAllocPer(myNgo.getPymtAllocPercentage());
                    tmdpMyNgo.setDtCreated(new Date());
                }
                else{
                    tmdpMyNgo.setfRecurPmtAllocPer(myNgo.getPymtAllocPercentage());
                }
                myNgoRepository.saveAndFlush(tmdpMyNgo);
            });
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new AppException("Frequency Update Failed");
        }
    }

    @Override
    public MyNgoResponse getMyNgo(User user) {
        MyNgoResponse myNgoResponse = null;
        try{
            MdpDonor mdpDonor = getDonorFromUser(user);
            List<TmdpMyNgo> tmdpMyNgoList =  myNgoRepository.findByDonorId(mdpDonor.getiDonorId());
            if(tmdpMyNgoList.size() >0)
                myNgoResponse = new MyNgoResponse();
            List<MyNgoResponse.NgoDetails> ngoDetailsList = new ArrayList<>();
            for(TmdpMyNgo tmdpMyNgo : tmdpMyNgoList)
            {
                MyNgoResponse.NgoDetails ngoDetails = new MyNgoResponse.NgoDetails();
                ngoDetails.setNgoId(tmdpMyNgo.getDonorNGoMapping().getiNgoId());
                ngoDetails.setPymtAllocPercentage(tmdpMyNgo.getfRecurPmtAllocPer());
                ngoDetailsList.add(ngoDetails);
            }
            myNgoResponse.setUserId(user.getId());
            myNgoResponse.setNgoDetails(ngoDetailsList);
        }catch (Exception e){
            e.printStackTrace();
            throw new AppException("Some Error Occurred ! Couldd not fetch Ngo");
        }
        return myNgoResponse;
    }

    @Override
    public DonorPymtFreqResponse getPymtFrequency(User user) {
        DonorPymtFreqResponse donorPymtFreqResponse = null;
        try{
            MdpDonor mdpDonor = getDonorFromUser(user);
            List<TmdpDonorRecurPmtSetup> tmdpDonorRecurPmtSetupList =  donorPymtFreqRepository.findByDonorId(mdpDonor.getiDonorId());
            if(tmdpDonorRecurPmtSetupList.size() >0)
                donorPymtFreqResponse = new DonorPymtFreqResponse();
            List<PaymentFrequency> pymtFreqList = new ArrayList<>();
            for(TmdpDonorRecurPmtSetup tmdpDonorRecurPmtSetup : tmdpDonorRecurPmtSetupList)
            {
                PaymentFrequency paymentFrequency = new PaymentFrequency();
                paymentFrequency.setNgoId(tmdpDonorRecurPmtSetup.getDonorNGoMapping().getiNgoId());
                paymentFrequency.setPaymentDay(tmdpDonorRecurPmtSetup.getiCycleDay());
                paymentFrequency.setPaymentGatewayCode(tmdpDonorRecurPmtSetup.getSzPaymentGetwayCode());
                paymentFrequency.setPaymentFrequency(tmdpDonorRecurPmtSetup.getSzPmtFreq());
                paymentFrequency.setAmount(tmdpDonorRecurPmtSetup.getfAmount());
                paymentFrequency.setNextReminderDate(tmdpDonorRecurPmtSetup.getDtNextReminder());
                pymtFreqList.add(paymentFrequency);
            }
            donorPymtFreqResponse.setUserId(user.getId());
            donorPymtFreqResponse.setDonorFrequency(pymtFreqList);
        }catch (Exception e){
            e.printStackTrace();
            throw new AppException("Some Error Occurred ! Could not fetch Payment Frequency");
        }
        return donorPymtFreqResponse;
    }

    @Override
    public boolean saveDonorReference(DonorReferenceRequest donorReferenceRequest) {

        Optional<User> userObj = userRepository.findById(donorReferenceRequest.getUserId());
        User user = userObj.get();
        MdpDonor mdpDonor = getDonorFromUser(user);
        try{
        TmdpDonorRef tmdpDonorRef  =  getDonorReferences(donorReferenceRequest);
        if(tmdpDonorRef == null)
        {
            if(donorReferenceRepository.existsBySzEmail(donorReferenceRequest.getEmail()))
                throw new AppException("Email Id already Exists");
            if(donorReferenceRepository.existsBySzMobile(donorReferenceRequest.getMobile()))
                throw new AppException("Mobile No already Exists");

            tmdpDonorRef = new TmdpDonorRef();
            tmdpDonorRef.setiDonorId(mdpDonor);
            tmdpDonorRef.setSzRefName(donorReferenceRequest.getReferenceName());
            tmdpDonorRef.setSzEmail(donorReferenceRequest.getEmail());
            tmdpDonorRef.setSzMobile(donorReferenceRequest.getMobile());
            tmdpDonorRef.setcConversionStatus(donorReferenceRequest.isConversationStatus());
            tmdpDonorRef.setiReminderNo(donorReferenceRequest.getReminderNo());
            Calendar calendar = new GregorianCalendar();
            tmdpDonorRef.setDtLastReminder(calendar);
        }
        else
        {
            tmdpDonorRef.setSzRefName(donorReferenceRequest.getReferenceName());
            tmdpDonorRef.setSzEmail(donorReferenceRequest.getEmail());
            tmdpDonorRef.setSzMobile(donorReferenceRequest.getMobile());
            tmdpDonorRef.setcConversionStatus(donorReferenceRequest.isConversationStatus());
            tmdpDonorRef.setiReminderNo(donorReferenceRequest.getReminderNo());
            Calendar calendar = new GregorianCalendar();
            tmdpDonorRef.setDtLastReminder(calendar);

        }
        donorReferenceRepository.saveAndFlush(tmdpDonorRef);
        return true;
    }catch (Exception e){
        throw new AppException(e.getMessage());
    }
    }

    @Override
    public DonorReferenceResponse getMyReferences(User user) {
        DonorReferenceResponse donorReferenceResponse = null;
        try{
            MdpDonor mdpDonor = getDonorFromUser(user);
            List<TmdpDonorRef> tmdpDonorRefList =  donorReferenceRepository.findByDonorId(mdpDonor.getiDonorId());
            if(tmdpDonorRefList.size() >0)
                donorReferenceResponse = new DonorReferenceResponse();
            List<DonorReferenceResponse.Reference> references = new ArrayList<>();
            for(TmdpDonorRef tmdpDonorRef : tmdpDonorRefList)
            {
                DonorReferenceResponse.Reference reference = new DonorReferenceResponse.Reference();
                reference.setEmail(tmdpDonorRef.getSzEmail());
                reference.setReferenceName(tmdpDonorRef.getSzRefName());
                reference.setMobile(tmdpDonorRef.getSzMobile());
                reference.setConversationStatus(tmdpDonorRef.iscConversionStatus());
                reference.setReminderNo(tmdpDonorRef.getiReminderNo());
                references.add(reference);
            }
            donorReferenceResponse.setUserId(user.getId());
            donorReferenceResponse.setReferences(references);
        }catch (Exception e){
            e.printStackTrace();
            throw new AppException("Some Error Occurred ! Couldd not fetch Ngo");
        }
        return donorReferenceResponse;
    }

    public TmdpMyNgo getMyNgoByDonor(DonorNGoMapping donorNGoMapping)
    {
        Optional<TmdpMyNgo> tmdpMyNgoObject =  myNgoRepository.findById(donorNGoMapping);
        TmdpMyNgo tmdpMyNgo = null;
        if(tmdpMyNgoObject.isPresent())
            tmdpMyNgo = tmdpMyNgoObject.get();
        return tmdpMyNgo;
    }

    public TmdpDonorRecurPmtSetup getDonorPymtFreqSetup(DonorNGoMapping donorNGoMapping)
    {
        Optional<TmdpDonorRecurPmtSetup> tmdpDonorRecurPmtSetupObj =  donorPymtFreqRepository.findById(donorNGoMapping);
        TmdpDonorRecurPmtSetup tmdpDonorRecurPmtSetup = null;
        if(tmdpDonorRecurPmtSetupObj.isPresent())
            tmdpDonorRecurPmtSetup = tmdpDonorRecurPmtSetupObj.get();
        return tmdpDonorRecurPmtSetup;
    }

    public TmdpDonorRef getDonorReferences(DonorReferenceRequest donorReferenceRequest)
    {
        Optional<TmdpDonorRef> tmdpDonorRefObj =  donorReferenceRepository.findBySzEmailAndSzMobile(donorReferenceRequest.getEmail(),donorReferenceRequest.getMobile());
        TmdpDonorRef tmdpDonorRef = null;
        if(tmdpDonorRefObj.isPresent())
            tmdpDonorRef = tmdpDonorRefObj.get();
        return tmdpDonorRef;
    }




}
