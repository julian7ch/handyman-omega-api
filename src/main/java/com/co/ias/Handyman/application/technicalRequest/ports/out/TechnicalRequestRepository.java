package com.co.ias.Handyman.application.technicalRequest.ports.out;


import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequest;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequestId;

public interface TechnicalRequestRepository {

    Integer store(TechnicalRequest technicalRequest);
    Integer getId(TechnicalRequestId technicalRequestId);
    TechnicalRequest update(TechnicalRequest technicalRequest);
    Integer delete(TechnicalRequestId technicalRequestId);
}
