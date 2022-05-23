package com.co.ias.Handyman.application.technicalRequest.services;

import com.co.ias.Handyman.application.technical.domain.Technical;

import com.co.ias.Handyman.application.technical.model.TechnicalDTO;
import com.co.ias.Handyman.application.technical.ports.out.TechnicalRepository;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequest;
import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.in.CreateTechnicalRequestUseCase;
import com.co.ias.Handyman.application.technicalRequest.ports.out.TechnicalRequestRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@Service
public class CreateTechnicalRequestService implements CreateTechnicalRequestUseCase {


    private final TechnicalRequestRepository technicalRequestRepository;
    private final TechnicalRepository technicalRepository;


    public CreateTechnicalRequestService(TechnicalRequestRepository technicalRequestRepository,
                                         TechnicalRepository technicalRepository) {

        this.technicalRequestRepository = technicalRequestRepository;
        this.technicalRepository = technicalRepository;
    }


    @Override
    public TechnicalRequestDTO execute(TechnicalRequestDTO technicalRequestDTO) throws SQLException {


        TechnicalRequest technicalRequest = technicalRequestDTO.toDomain();

        boolean existsId = technicalRepository.existsById(technicalRequestDTO.getTechnicalId());

        if (existsId == true){
            technicalRequestRepository.save(technicalRequestDTO);
            return technicalRequestDTO;
        } else {
            throw new SQLException("No access");

        }



    }



}
