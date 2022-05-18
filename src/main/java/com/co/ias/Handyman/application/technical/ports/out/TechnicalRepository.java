package com.co.ias.Handyman.application.technical.ports.out;


import com.co.ias.Handyman.application.technical.domain.Technical;
import com.co.ias.Handyman.application.technical.domain.TechnicalId;

public interface TechnicalRepository {
    Integer store(Technical technical);
    Integer getId(Technical technicalId);
    Technical update(Technical technical);
    Integer delete(TechnicalId technicalIdId);
}
