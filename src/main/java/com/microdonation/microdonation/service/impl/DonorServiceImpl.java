package com.microdonation.microdonation.service.impl;

import com.microdonation.microdonation.exception.AppException;
import com.microdonation.microdonation.model.*;
import com.microdonation.microdonation.payload.DonorNGoPymtFreqRequest;
import com.microdonation.microdonation.payload.MdpDonorDetails;
import com.microdonation.microdonation.payload.MdpNGoDetails;
import com.microdonation.microdonation.repository.DonorPymtFreqRepository;
import com.microdonation.microdonation.repository.DonorRepository;
import com.microdonation.microdonation.repository.NgoRepository;
import com.microdonation.microdonation.repository.UserRepository;
import com.microdonation.microdonation.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

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

    public boolean saveDonorFrequency(DonorNGoPymtFreqRequest donorNGoPymtFreqRequest){
        Optional<User> userObj = userRepository.findById(donorNGoPymtFreqRequest.getUserId());
        try{
            User user = userObj.get();
            MdpDonor mdpDonor = donorRepository.findByUser(user);

            donorNGoPymtFreqRequest.getDonorFrequency().forEach(frequency -> {
                TmdpDonorRecurPmtSetup tmdpDonorRecurPmtSetup = new TmdpDonorRecurPmtSetup();
                DonorNGoMapping  donorNGoMapping = new DonorNGoMapping(mdpDonor.getiDonorId(),frequency.getNgoId());
                tmdpDonorRecurPmtSetup.setDonorNGoMapping(donorNGoMapping);
                tmdpDonorRecurPmtSetup.setiCycleDay(frequency.getPaymentDay());
                tmdpDonorRecurPmtSetup.setSzPaymentGetwayCode(frequency.getPaymentGatewayCode());
                tmdpDonorRecurPmtSetup.setDtCreated(new Date());
                tmdpDonorRecurPmtSetup.setfAmount(frequency.getAmount());
                tmdpDonorRecurPmtSetup.setSzPmtFreq(frequency.getPaymentFrequency());
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





}
