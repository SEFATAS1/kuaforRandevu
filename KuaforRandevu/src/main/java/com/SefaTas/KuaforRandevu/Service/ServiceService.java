package com.SefaTas.KuaforRandevu.Service;

import com.SefaTas.KuaforRandevu.Dto.ServiceDto;

import java.util.List;

public interface ServiceService {
    ServiceDto addService(ServiceDto serviceDto);
    List<ServiceDto> findAllServices();
    ServiceDto updateService(Long serviceId, ServiceDto updatedServices);
    void deleteService(Long serviceId);
}
