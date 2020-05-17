package com.microdonation.microdonation.service;

import com.microdonation.microdonation.model.MdpNgo;
import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.payload.DonorReferenceRequest;
import com.microdonation.microdonation.payload.MdpNGoDetails;
import com.microdonation.microdonation.payload.NgoReferenceRequest;
import com.microdonation.microdonation.payload.NgoReferenceResponse;

public interface NgoService {
    public void createNgoDetails(MdpNGoDetails mdpNGoDetails);
    public void updateNgoDetails(MdpNGoDetails mdpNGoDetails);
    public  MdpNgo getNgoFromUser(User user);
    public boolean saveNgoReference(NgoReferenceRequest referenceRequest);
    public NgoReferenceResponse getMyReferences(User user);
}
