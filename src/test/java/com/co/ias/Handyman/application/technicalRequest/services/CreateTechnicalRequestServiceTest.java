package com.co.ias.Handyman.application.technicalRequest.services;

import com.co.ias.Handyman.application.service.ports.out.ServiceRepository;
import com.co.ias.Handyman.application.technical.ports.out.TechnicalRepository;
import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.out.TechnicalRequestRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class CreateTechnicalRequestServiceTest {

    @InjectMocks
    private CreateTechnicalRequestService createTechnicalRequestService;

    @Mock
    private TechnicalRequestRepository technicalRequestRepository;
    @Mock
    private  TechnicalRepository technicalRepository;
    @Mock
    private  ServiceRepository serviceRepository;



    @Test
    public void execute() throws SQLException, FileNotFoundException, NoSuchFieldException {
        TechnicalRequestDTO technicalRequest = new TechnicalRequestDTO(1,1,2, LocalDateTime.now(),LocalDateTime.now());
        when(technicalRepository.existsById(technicalRequest.technicalId)).thenReturn(true);
        when(serviceRepository.existsById(technicalRequest.getRequestId())).thenReturn(true);
        when( technicalRequestRepository.existsTechnicalRequestDTOByStartDayAndEndDay(technicalRequest.getStartDay(), technicalRequest.getEndDay())).thenReturn(false);
        when(technicalRequestRepository.save(technicalRequest)).thenReturn(technicalRequest);
        TechnicalRequestDTO response = this.createTechnicalRequestService.execute(technicalRequest);
        assertNotNull(response);
    }


}