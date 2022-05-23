package com.co.ias.Handyman.application.technicalRequest.services;

import com.co.ias.Handyman.application.service.ports.out.ServiceRepository;
import com.co.ias.Handyman.application.technical.ports.out.TechnicalRepository;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequest;
import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.in.CreateTechnicalRequestUseCase;
import com.co.ias.Handyman.application.technicalRequest.ports.out.TechnicalRequestRepository;
import org.springframework.stereotype.Service;


import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class CreateTechnicalRequestService implements CreateTechnicalRequestUseCase {


    private final TechnicalRequestRepository technicalRequestRepository;
    private final TechnicalRepository technicalRepository;

    private final ServiceRepository serviceRepository;


    public CreateTechnicalRequestService(TechnicalRequestRepository technicalRequestRepository,
                                         TechnicalRepository technicalRepository,
                                         ServiceRepository serviceRepository) {

        this.technicalRequestRepository = technicalRequestRepository;
        this.technicalRepository = technicalRepository;
        this.serviceRepository = serviceRepository;
    }


    @Override
    public TechnicalRequestDTO execute(TechnicalRequestDTO technicalRequestDTO) throws SQLException, FileNotFoundException, NoSuchFieldException {


        TechnicalRequest technicalRequest = technicalRequestDTO.toDomain();

        boolean existsIdTech = technicalRepository.existsById(technicalRequestDTO.getTechnicalId());

        boolean existsIdService = serviceRepository.existsById(technicalRequestDTO.getRequestId());

        boolean existsDate = technicalRequestRepository.existsTechnicalRequestDTOByStartDayAndEndDay(technicalRequestDTO.getStartDay(), technicalRequestDTO.getEndDay());

        /*
         Boolean for create service after actual day
        */
        LocalDateTime now = LocalDateTime.now();
        boolean startAfterNow = technicalRequestDTO.getStartDay().isAfter(now);

        Long daysBeforeService = ChronoUnit.DAYS.between(technicalRequestDTO.getStartDay(),
                now);

        if (existsIdTech == true){
            return getTechnicalRequestDTO(technicalRequestDTO, existsIdService, existsDate, startAfterNow, daysBeforeService);
        } else {
            throw new SQLException("Data Not Found");

        }

    }

    private TechnicalRequestDTO getTechnicalRequestDTO(TechnicalRequestDTO technicalRequestDTO, boolean existsIdService, boolean existsDate, boolean startAfterNow, Long daysBeforeService) throws NoSuchFieldException, FileNotFoundException {
        if (existsIdService == true){
            return getTechnicalRequestDTO(technicalRequestDTO, existsDate, startAfterNow, daysBeforeService);
        } else{
            throw new FileNotFoundException("Data Not Found");
        }
    }

    private TechnicalRequestDTO getTechnicalRequestDTO(TechnicalRequestDTO technicalRequestDTO, boolean existsDate, boolean startAfterNow, Long daysBeforeService) throws NoSuchFieldException {
        if(existsDate == false){
            return getTechnicalRequestDTO(technicalRequestDTO, startAfterNow, daysBeforeService);

        } else {
            throw new NoSuchFieldException("Data Not Found");
        }
    }

    private TechnicalRequestDTO getTechnicalRequestDTO(TechnicalRequestDTO technicalRequestDTO, boolean startAfterNow, Long daysBeforeService) {
        if(!startAfterNow && daysBeforeService < 7){
            technicalRequestRepository.save(technicalRequestDTO);
            return technicalRequestDTO;
        } else{
            throw new DateTimeException("Days Wrong");
        }
    }


}
