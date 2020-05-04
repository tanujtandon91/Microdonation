package com.microdonation.microdonation.service;


import com.microdonation.microdonation.payload.DonorNGoPymtFreqRequest;
import com.microdonation.microdonation.payload.MdpDonorDetails;

public interface DonorService {

    public boolean saveDonorFrequency(DonorNGoPymtFreqRequest donorNGoPymtFreqRequest);

    public void createDonorDetails(MdpDonorDetails mdpDonorDetails);
}
