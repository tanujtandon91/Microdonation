package com.microdonation.microdonation.service.impl;

import com.microdonation.microdonation.exception.AppException;
import com.microdonation.microdonation.payload.MdpNGoDetails;
import com.microdonation.microdonation.model.MdpDonor;
import com.microdonation.microdonation.model.MdpNgo;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.repository.NgoRepository;
import com.microdonation.microdonation.service.NgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

@Service
public class NgoServiceImpl implements NgoService {

    @Autowired
    NgoRepository ngoRepository;
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
        try {
            Optional<MdpNgo> mdpNgoObject = ngoRepository.findById(mdpNGoDetails.getId());
            MdpNgo mdpNgo = mdpNgoObject.get();
            mdpNgo.setUser(mdpNGoDetails.getUser());
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
            mdpNgo.setDtRegistration(mdpNGoDetails.getRedistrationDate());
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

}
