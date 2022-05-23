package com.co.ias.Handyman.application.technicalRequest.model;

import com.co.ias.Handyman.application.request.domain.RequestId;
import com.co.ias.Handyman.application.technical.domain.TechnicalId;

import com.co.ias.Handyman.application.technicalRequest.domain.EndDay;
import com.co.ias.Handyman.application.technicalRequest.domain.StartDay;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequest;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequestId;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;



public class TechnicalRequestDBO {

    private Integer technicalRequestId;

    private Integer requestId;

    public Integer technicalId;

    private LocalDateTime startDay;

    private  LocalDateTime endDay;


    public TechnicalRequestDBO (){

    }

    public TechnicalRequestDBO(Integer technicalRequestId, Integer requestId, Integer technicalId, LocalDateTime startDay, LocalDateTime endDay) {
        this.technicalRequestId = technicalRequestId;
        this.requestId = requestId;
        this.technicalId = technicalId;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public static TechnicalRequestDBO fromResultSet(ResultSet resultSet) throws SQLException {
        TechnicalRequestDBO technicalRequestDBO = new TechnicalRequestDBO();
        technicalRequestDBO.setTechnicalRequestId(resultSet.getInt("id_technical_request"));
        technicalRequestDBO.setRequestId(resultSet.getInt("id_request"));
        technicalRequestDBO.setTechnicalId(resultSet.getInt("id_technical"));
        technicalRequestDBO.setStartDay(resultSet.getTimestamp("start_day").toLocalDateTime() );
        technicalRequestDBO.setEndDay(resultSet.getTimestamp("end_day").toLocalDateTime());

        return technicalRequestDBO;
    }

    public TechnicalRequest toDomain(){
        return  new TechnicalRequest(
          new TechnicalRequestId(technicalRequestId),
                new RequestId(requestId),
                new TechnicalId(technicalId),
                new StartDay(startDay),
                new EndDay(endDay)
        );
    }


    /*
     Getters and Setters
    */

    public Integer getTechnicalRequestId() {
        return technicalRequestId;
    }

    public void setTechnicalRequestId(Integer technicalRequestId) {
        this.technicalRequestId = technicalRequestId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getTechnicalId() {
        return technicalId;
    }

    public void setTechnicalId(Integer technicalId) {
        this.technicalId = technicalId;
    }

    public LocalDateTime getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDateTime startDay) {
        this.startDay = startDay;
    }

    public LocalDateTime getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDateTime endDay) {
        this.endDay = endDay;
    }
}
