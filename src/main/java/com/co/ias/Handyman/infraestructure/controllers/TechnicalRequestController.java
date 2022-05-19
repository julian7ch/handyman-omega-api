package com.co.ias.Handyman.infraestructure.controllers;

import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.in.CreateTechnicalRequestUseCase;
import com.co.ias.Handyman.shared.errors.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnicalRequestController {

    private CreateTechnicalRequestUseCase createTechnicalRequestUseCase;

    public TechnicalRequestController(CreateTechnicalRequestUseCase createTechnicalRequestUseCase){
        this.createTechnicalRequestUseCase = createTechnicalRequestUseCase;
    }

    @RequestMapping(value = "/technical/request", method = RequestMethod.POST)
    public ResponseEntity<?> createTechRequest(@RequestBody TechnicalRequestDTO technicalRequestDTO){

        try{
             TechnicalRequestDTO techRequest = createTechnicalRequestUseCase.execute(technicalRequestDTO);
             return ResponseEntity.ok(techRequest);


        } catch (IllegalArgumentException | NullPointerException exception ){
            ApplicationError appError = new ApplicationError(
                    "Input no Validation",
                    "Bad Input data"
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(appError);
        } catch (Exception exception){
            ApplicationError appError = new ApplicationError(
                    "SystemError",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(appError);
        }


    }

}
