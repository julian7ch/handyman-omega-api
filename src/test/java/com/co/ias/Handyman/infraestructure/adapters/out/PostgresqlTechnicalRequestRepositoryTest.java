package com.co.ias.Handyman.infraestructure.adapters.out;

import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.out.TechnicalRequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class PostgresqlTechnicalRequestRepositoryTest {

    @Autowired
    private TechnicalRequestRepository technicalRequestRepository;

    @Test
    void saveServiceSuccess() {
        TechnicalRequestDTO technicalRequest = new TechnicalRequestDTO(1,1,2, LocalDateTime.now() , LocalDateTime.now());

        TechnicalRequestDTO saveService = technicalRequestRepository.save(technicalRequest);
        Optional<TechnicalRequestDTO> querytechnicalRequest  = technicalRequestRepository.findById(saveService.getTechnicalRequestId());

        assertNotNull(saveService);
        assertEquals(saveService.getRequestId(), querytechnicalRequest.get().getRequestId());
    }

    @Test
    void queryService(){
        TechnicalRequestDTO technicalRequest = new TechnicalRequestDTO(1,1,2,LocalDateTime.now(),LocalDateTime.now());

        TechnicalRequestDTO saveService = technicalRequestRepository.save(technicalRequest);

        Optional<TechnicalRequestDTO> querytechnicalRequest  = technicalRequestRepository.findById(saveService.getTechnicalRequestId());

        assertNotNull(querytechnicalRequest);
        assertEquals(querytechnicalRequest.get().getTechnicalId(), saveService.getTechnicalId());


    }

}