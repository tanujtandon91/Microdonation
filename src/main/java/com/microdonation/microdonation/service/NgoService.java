package com.microdonation.microdonation.service;

import com.microdonation.microdonation.model.MdpNgo;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.payload.MdpNGoDetails;

public interface NgoService {
    public void createNgoDetails(MdpNGoDetails mdpNGoDetails);
    public void updateNgoDetails(MdpNGoDetails mdpNGoDetails);
    public  MdpNgo getNgoFromUser(User user);
}
