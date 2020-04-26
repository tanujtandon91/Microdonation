package com.microdonation.microdonation.service;

import com.microdonation.microdonation.payload.MdpNGoDetails;

public interface NgoService {
    public void createNgoDetails(MdpNGoDetails mdpNGoDetails);
    public void updateNgoDetails(MdpNGoDetails mdpNGoDetails);
}
