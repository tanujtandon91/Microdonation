package com.microdonation.microdonation.service;


import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.payload.*;

public interface DonorService {

    public boolean saveDonorFrequency(DonorNGoPymtFreqRequest donorNGoPymtFreqRequest);

    public void createDonorDetails(MdpDonorDetails mdpDonorDetails);

    public boolean saveOrUpdateMyNgo(MyNgoRequest myNgoRequest);

    public MyNgoResponse getMyNgo(User user);

    public DonorPymtFreqResponse getPymtFrequency(User user);

    public boolean saveDonorReference(DonorReferenceRequest donorReferenceRequest);

    public DonorReferenceResponse getMyReferences(User user);
}
