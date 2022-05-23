package com.co.ias.Handyman.infraestructure.controllers;

import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.in.CreateTechnicalRequestUseCase;
import com.co.ias.Handyman.shared.errors.ApplicationError;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.cache.support.NullValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.DateTimeException;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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


        } catch (SQLException exception){
            ApplicationError appError = new ApplicationError(
                    "No se encuentra el ID del técnico especificado.",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(appError);

        } catch (FileNotFoundException exception){
            ApplicationError appError = new ApplicationError(
                    "No se encuentra el ID del servicio especificado.",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(appError);

        } catch (NoSuchFieldException exception){

            ApplicationError appError = new ApplicationError(
                    "No se puede crear una petición de servicio técnico para una fecha ya utilizada.",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(appError);

        } catch (DateTimeException exception){

            ApplicationError appError = new ApplicationError(
                    "No se puede crear una petición de servicio técnico con más de 7 días atrás, " +
                            "o después de la fecha actual.",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(appError);

        }
        catch (IllegalArgumentException | NullPointerException exception ){
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
