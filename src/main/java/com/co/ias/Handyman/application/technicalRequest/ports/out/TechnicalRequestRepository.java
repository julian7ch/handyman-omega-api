package com.co.ias.Handyman.application.technicalRequest.ports.out;






import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequest;
import com.co.ias.Handyman.application.technicalRequest.domain.TechnicalRequestId;
import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import org.springframework.data.repository.CrudRepository;


import java.time.LocalDateTime;
import java.util.Optional;


public interface TechnicalRequestRepository extends CrudRepository<TechnicalRequestDTO,Integer> {

    boolean existsTechnicalRequestDTOByStartDayAndEndDay(LocalDateTime startDay, LocalDateTime endDay);


}
