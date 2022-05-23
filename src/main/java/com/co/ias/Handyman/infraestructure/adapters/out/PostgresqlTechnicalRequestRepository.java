package com.co.ias.Handyman.infraestructure.adapters.out;


import com.co.ias.Handyman.application.technical.model.TechnicalDBO;
import com.co.ias.Handyman.application.technical.ports.out.TechnicalRepository;
import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.out.TechnicalRequestRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgresqlTechnicalRequestRepository  {

    private final DataSource dataSource;
    private TechnicalRequestRepository technicalRequestRepository;
    private TechnicalRepository technicalRepository;

    public PostgresqlTechnicalRequestRepository(DataSource dataSource,
                                                TechnicalRequestRepository technicalRequestRepository,
                                                TechnicalRepository technicalRepository) {

        this.dataSource = dataSource;
        this.technicalRequestRepository = technicalRequestRepository;
        this.technicalRepository = technicalRepository;
    }


    public Integer save(TechnicalRequestDTO technicalRequestDTO){



        try(Connection connection = dataSource.getConnection()) {

            TechnicalRequestDTO techRequest = technicalRequestRepository.save(technicalRequestDTO);


        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }

        return technicalRequestDTO.getRequestId();

    }

    public boolean existsById(Integer technicalId){

        try (Connection connection = dataSource.getConnection()){

            boolean existsTech = technicalRepository.existsById(technicalId);

        } catch (SQLException exception){
            throw new RuntimeException("Error querying database", exception);
        }
        return true;
    }


}
