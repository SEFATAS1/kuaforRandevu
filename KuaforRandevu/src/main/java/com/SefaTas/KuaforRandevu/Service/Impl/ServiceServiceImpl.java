package com.SefaTas.KuaforRandevu.Service.Impl;

import com.SefaTas.KuaforRandevu.Dto.ServiceDto;
import com.SefaTas.KuaforRandevu.Exception.SourceNotFoundException;
import com.SefaTas.KuaforRandevu.Mapper.ServiceMapper;
import com.SefaTas.KuaforRandevu.Repository.ServiceRepository;
import com.SefaTas.KuaforRandevu.Service.ServiceService;
import com.SefaTas.KuaforRandevu.Entity.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceDto addService(ServiceDto serviceDto) {
        Service service = ServiceMapper.mapToService(serviceDto);
        Service registeredService = serviceRepository.save(service);
        return ServiceMapper.mapToServiceDto(registeredService);
    }

    @Override
    public List<ServiceDto> findAllServices() {
        List<Service> services = serviceRepository.findAll();
        return services.stream().map((service -> ServiceMapper.mapToServiceDto(service))).collect(Collectors.toList());
    }

    @Override
    public ServiceDto updateService(Long serviceId, ServiceDto updatedServices) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new SourceNotFoundException("Girilen id ile ilişkili bir kayıt bulunanmadı. Id: " + serviceId));

        service.setServiceName(updatedServices.getServiceName());
        service.setDuration(updatedServices.getDuration());
        service.setPrice(updatedServices.getPrice());

        Service updateserviceInDatabase = serviceRepository.save(service);

        return ServiceMapper.mapToServiceDto(updateserviceInDatabase);
    }

    @Override
    public void deleteService(Long serviceId) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new SourceNotFoundException("Girilen id ile ilişkili bir kayıt bulunanmadı. Id: " + serviceId));

        serviceRepository.deleteById(serviceId);
    }
}
