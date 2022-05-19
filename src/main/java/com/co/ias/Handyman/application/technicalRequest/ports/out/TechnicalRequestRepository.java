package com.co.ias.Handyman.application.technicalRequest.ports.out;





import com.co.ias.Handyman.application.technicalRequest.model.TechnicalRequestDTO;
import org.springframework.data.repository.CrudRepository;


public interface TechnicalRequestRepository extends CrudRepository<TechnicalRequestDTO,Integer> {


}
