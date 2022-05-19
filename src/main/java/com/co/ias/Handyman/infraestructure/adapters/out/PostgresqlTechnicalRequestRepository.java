package com.co.ias.Handyman.infraestructure.adapters.out;

import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequest;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequestId;
import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import com.co.ias.Handyman.application.technicalRequest.ports.out.TechnicalRequestRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgresqlTechnicalRequestRepository  {

    private final DataSource dataSource;
    private TechnicalRequestRepository technicalRequestRepository;

    public PostgresqlTechnicalRequestRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public Integer store(TechnicalRequestDTO technicalRequestDTO){



        try(Connection connection = dataSource.getConnection()) {

            TechnicalRequestDTO techRequest = technicalRequestRepository.save(technicalRequestDTO);


        } catch (SQLException exception) {
            throw new RuntimeException("Error querying database", exception);
        }

        return technicalRequestDTO.getRequestId();

    }


}
