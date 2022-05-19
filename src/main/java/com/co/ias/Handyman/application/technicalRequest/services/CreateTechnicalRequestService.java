package com.co.ias.Handyman.application.technicalRequest.services;

import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequest;
import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.in.CreateTechnicalRequestUseCase;
import com.co.ias.Handyman.application.technicalRequest.ports.out.TechnicalRequestRepository;
import com.co.ias.Handyman.infraestructure.adapters.out.PostgresqlTechnicalRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTechnicalRequestService implements CreateTechnicalRequestUseCase {


    private final TechnicalRequestRepository technicalRequestRepository;

    public CreateTechnicalRequestService(TechnicalRequestRepository technicalRequestRepository) {

        this.technicalRequestRepository = technicalRequestRepository;
    }


    @Override
    public TechnicalRequestDTO execute(TechnicalRequestDTO technicalRequestDTO) {


        technicalRequestDTO.toDomain();



        technicalRequestRepository.save(technicalRequestDTO);




        return technicalRequestDTO;
    }
}
