package com.microdonation.microdonation.service.impl;

import com.microdonation.microdonation.exception.AppException;
import com.microdonation.microdonation.model.*;
import com.microdonation.microdonation.payload.*;
import com.microdonation.microdonation.repository.NgoReferenceRepository;
import com.microdonation.microdonation.repository.NgoRepository;
import com.microdonation.microdonation.repository.UserRepository;
import com.microdonation.microdonation.service.NgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class NgoServiceImpl implements NgoService {

    @Autowired
    NgoRepository ngoRepository;

    @Autowired
    NgoReferenceRepository ngoReferenceRepository;

    @Autowired
    UserRepository userRepository;

    public void createNgoDetails(MdpNGoDetails mdpNGoDetails)
    {
        try {
           MdpNgo mdpNgo = new MdpNgo();
            mdpNgo.setUser(mdpNGoDetails.getUser());
            mdpNgo.setSzNgoName(mdpNGoDetails.getNgoName());
            mdpNgo.setSzEmail(mdpNGoDetails.getEmail());
            mdpNgo.setSzMobile(mdpNGoDetails.getMobile());
            mdpNgo.setSzRegistrationId(mdpNGoDetails.getRegistrationId());
            mdpNgo.setDtCreatedDate(new Date());
            ngoRepository.saveAndFlush(mdpNgo);
        }catch (Exception e)
        {
            throw  new AppException(e.getMessage());
        }
    }

    public void updateNgoDetails(MdpNGoDetails mdpNGoDetails)
    {
        Optional<User> userObj = userRepository.findById(mdpNGoDetails.getUserId());
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date date = sdf.parse(mdpNGoDetails.getRedistrationDate());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            User user = userObj.get();
            MdpNgo mdpNgo = getNgoFromUser(user);
            mdpNgo.setUser(user);
            mdpNgo.setSzNgoName(mdpNGoDetails.getNgoName());
            mdpNgo.setSzEmail(mdpNGoDetails.getEmail());
            mdpNgo.setSzMobile(mdpNGoDetails.getMobile());
            mdpNgo.setSzRegistrationId(mdpNGoDetails.getRegistrationId());
            mdpNgo.setSzWebsite(mdpNGoDetails.getWebsite());
            mdpNgo.setSzAddressLine1(mdpNGoDetails.getAddressLine1());
            mdpNgo.setSzAddressAine2(mdpNGoDetails.getAddressLine2());
            mdpNgo.setSzPhone1(mdpNGoDetails.getContactNo1());
            mdpNgo.setSzPhone2(mdpNGoDetails.getContactNo2());
            mdpNgo.setSzBankAccountNo(mdpNGoDetails.getBankAccountNo());
            mdpNgo.setSzCategoryPrimary(mdpNGoDetails.getPrimaryCategory());
            mdpNgo.setSzCategorySecondary(mdpNGoDetails.getSecondaryCategory());
            mdpNgo.setSzCity(mdpNGoDetails.getCity());
            mdpNgo.setSzCountry(mdpNGoDetails.getCountry());
            mdpNgo.setSzPostalCode(mdpNGoDetails.getPincode());
            mdpNgo.setSzVerifiedBy(mdpNGoDetails.getVeriifiedBy());
            mdpNgo.setDtRegistration(cal);
            mdpNgo.setcNgoStatus(mdpNGoDetails.isStatus());
            mdpNgo.setSzIfscCode(mdpNGoDetails.getIfsc());
            Calendar calendar = new GregorianCalendar();
            mdpNgo.setDtVerifiedDate(calendar);
            ngoRepository.saveAndFlush(mdpNgo);
        }catch (Exception e)
        {
            throw  new AppException("Ngo Data Save Failed");
        }
    }
    
    public  MdpNgo getNgoFromUser(User user)
    {
        MdpNgo mdpNgo = ngoRepository.findByUser(user);
        return mdpNgo;
    }

    @Override
    public boolean saveNgoReference(NgoReferenceRequest referenceRequest) {

        Optional<User> userObj = userRepository.findById(referenceRequest.getUserId());
        User user = userObj.get();
        MdpNgo mdpNgo = getNgoFromUser(user);
        try{
            TmdpNgoRef tmdpNgoRef  =  getNgoReferences(referenceRequest);
            if(tmdpNgoRef == null)
            {
                if(ngoReferenceRepository.existsBySzEmail(referenceRequest.getEmail()))
                    throw new AppException("Email Id already Exists");
                if(ngoReferenceRepository.existsBySzMobile(referenceRequest.getMobile()))
                    throw new AppException("Mobile No already Exists");

                tmdpNgoRef = new TmdpNgoRef();
                tmdpNgoRef.setiNgoId(mdpNgo);
                tmdpNgoRef.setSzRefName(referenceRequest.getReferenceName());
                tmdpNgoRef.setSzEmail(referenceRequest.getEmail());
                tmdpNgoRef.setSzMobile(referenceRequest.getMobile());
                tmdpNgoRef.setcConversionStatus(referenceRequest.isConversationStatus());
                tmdpNgoRef.setiReminderNo(referenceRequest.getReminderNo());
                Calendar calendar = new GregorianCalendar();
                tmdpNgoRef.setDtLastReminder(calendar);
            }
            else
            {
                tmdpNgoRef.setSzRefName(referenceRequest.getReferenceName());
                tmdpNgoRef.setSzEmail(referenceRequest.getEmail());
                tmdpNgoRef.setSzMobile(referenceRequest.getMobile());
                tmdpNgoRef.setcConversionStatus(referenceRequest.isConversationStatus());
                tmdpNgoRef.setiReminderNo(referenceRequest.getReminderNo());
                Calendar calendar = new GregorianCalendar();
                tmdpNgoRef.setDtLastReminder(calendar);

            }
            ngoReferenceRepository.saveAndFlush(tmdpNgoRef);
            return true;
        }catch (Exception e){
            throw new AppException(e.getMessage());
        }
    }
    public TmdpNgoRef getNgoReferences(NgoReferenceRequest referenceRequest)
    {
        Optional<TmdpNgoRef> tmdpNgoRefObj =  ngoReferenceRepository.findBySzEmailAndSzMobile(referenceRequest.getEmail(),referenceRequest.getMobile());
        TmdpNgoRef tmdpNgoRef = null;
        if(tmdpNgoRefObj.isPresent())
            tmdpNgoRef = tmdpNgoRefObj.get();
        return tmdpNgoRef;
    }

    public NgoReferenceResponse getMyReferences(User user) {
        NgoReferenceResponse ngoReferenceResponse = null;
        try {
            MdpNgo mdpNgo = getNgoFromUser(user);
            List<TmdpNgoRef> tmdpNgoRefList = ngoReferenceRepository.findByNgoId(mdpNgo.getiNgoId());
            if (tmdpNgoRefList.size() > 0)
                ngoReferenceResponse = new NgoReferenceResponse();
            List<NgoReferenceResponse.Reference> references = new ArrayList<>();
            for (TmdpNgoRef tmdpNgoRef : tmdpNgoRefList) {
                NgoReferenceResponse.Reference reference = new NgoReferenceResponse.Reference();
                reference.setEmail(tmdpNgoRef.getSzEmail());
                reference.setReferenceName(tmdpNgoRef.getSzRefName());
                reference.setMobile(tmdpNgoRef.getSzMobile());
                reference.setConversationStatus(tmdpNgoRef.iscConversionStatus());
                reference.setReminderNo(tmdpNgoRef.getiReminderNo());
                references.add(reference);
            }
            ngoReferenceResponse.setUserId(user.getId());
            ngoReferenceResponse.setReferences(references);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("Some Error Occurred ! Could not fetch References");
        }
        return ngoReferenceResponse;
    }

}
