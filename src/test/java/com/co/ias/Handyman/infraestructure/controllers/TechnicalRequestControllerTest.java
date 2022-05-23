package com.co.ias.Handyman.infraestructure.controllers;

import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.in.CreateTechnicalRequestUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class TechnicalRequestControllerTest {

    @InjectMocks
    private TechnicalRequestController technicalRequestController;

    @Mock
    private CreateTechnicalRequestUseCase createTechnicalRequestUseCase;

    @Test
    public void create() throws SQLException, FileNotFoundException, NoSuchFieldException{
        TechnicalRequestDTO technicalRequest = new TechnicalRequestDTO(1,1,2, LocalDateTime.now(),LocalDateTime.now());
        technicalRequest.toDomain();
        when(createTechnicalRequestUseCase.execute(technicalRequest)).thenReturn(technicalRequest);
        ResponseEntity<?> responde = technicalRequestController.createTechRequest(technicalRequest);
        assertNotNull(responde);
    }

}