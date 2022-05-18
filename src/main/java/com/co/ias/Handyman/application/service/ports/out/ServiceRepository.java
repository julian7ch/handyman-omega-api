package com.co.ias.Handyman.application.service.ports.out;


import com.co.ias.Handyman.application.service.domain.Service;
import com.co.ias.Handyman.application.service.domain.ServiceId;

public interface ServiceRepository {
    Integer store(Service product);
    Integer getId(ServiceId productId);
    Service update(Service product);
    Integer delete(ServiceId productId);

}
