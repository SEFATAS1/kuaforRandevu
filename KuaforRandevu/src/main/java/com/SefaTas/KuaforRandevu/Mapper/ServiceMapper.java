package com.SefaTas.KuaforRandevu.Mapper;


import com.SefaTas.KuaforRandevu.Dto.ServiceDto;
import com.SefaTas.KuaforRandevu.Entity.Service;

public class ServiceMapper {
    public static ServiceDto mapToServiceDto(Service service){
        return new ServiceDto(
                service.getId(),
                service.getServiceName(),
                service.getDuration(),
                service.getPrice()
        );
    }

    public static Service mapToService(ServiceDto serviceDto){
        return new Service(
                serviceDto.getId(),
                serviceDto.getServiceName(),
                serviceDto.getDuration(),
                serviceDto.getPrice()
        );
    }

}
