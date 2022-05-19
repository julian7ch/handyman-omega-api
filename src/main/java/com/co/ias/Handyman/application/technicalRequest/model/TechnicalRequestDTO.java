package com.co.ias.Handyman.application.technicalRequest.model;

import com.co.ias.Handyman.application.request.domain.RequestId;
import com.co.ias.Handyman.application.technical.domain.TechnicalId;
import com.co.ias.Handyman.application.technicalRequest.domain.EndDay;
import com.co.ias.Handyman.application.technicalRequest.domain.StartDay;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequest;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequestId;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "technical_request") // mantener en minúsculas en la DB
public class TechnicalRequestDTO {


    /*
      Technical Request DTO Attributes
    */
    @Id
    @SequenceGenerator(name = "technical_request_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_technical_request", unique = true, nullable = false)
    private Integer technicalRequestId;






    @Column(name = "id_request")
    private  Integer requestId;
    @Column(name = "id_technical")
    private  Integer technicalId;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private  Date startDay;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private  Date endDay;

    /*
      No Args Constructor
    */
    public TechnicalRequestDTO() {
    }

    /*
      All Args Constructor
    */
    public TechnicalRequestDTO(Integer technicalRequestId, Integer requestId,  Integer technicalId, Date startDay, Date endDay) {
        this.technicalRequestId = technicalRequestId;
        this.requestId = requestId;
        this.technicalId = technicalId;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    /*
      Method To domain
    */
    public TechnicalRequest toDomain(){
        return new TechnicalRequest(
                new TechnicalRequestId(technicalRequestId),
                new RequestId(requestId),
                new TechnicalId(technicalId),
                new StartDay(startDay),
                new EndDay(endDay)
        );
    }

    /*
     Method From Domain
    */
    public static TechnicalRequestDTO fromDomain(TechnicalRequest technicalRequest){
        return new TechnicalRequestDTO(
          technicalRequest.getTechnicalRequestId().getValue(),
          technicalRequest.getRequestId().getValue(),
          technicalRequest.getTechnicalId().getValue(),
          technicalRequest.getStartDay().getValue(),
          technicalRequest.getEndDay().getValue()
        );
    }

    /*
      Getters and Setters
    */


    public Integer getTechnicalRequestId() {
        return this.technicalRequestId;
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

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }
}
