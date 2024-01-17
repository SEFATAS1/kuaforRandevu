package com.SefaTas.KuaforRandevu.Controller;

import com.SefaTas.KuaforRandevu.Dto.ServiceDto;
import com.SefaTas.KuaforRandevu.Service.ServiceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/api/v1/services")
    public ResponseEntity<ServiceDto> addService(@RequestBody ServiceDto serviceDto){
        ServiceDto registeredService = serviceService.addService(serviceDto);
        return new ResponseEntity<>(registeredService, HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/services")
    public ResponseEntity<List<ServiceDto>> findAllServices(){
        List<ServiceDto> serviceDtoList = serviceService.findAllServices();
        return ResponseEntity.ok(serviceDtoList);
    }

    @PutMapping("/api/v1/services/{Id}")
    public ResponseEntity<ServiceDto> updateService(@PathVariable("Id") Long serviceId, @RequestBody ServiceDto currentServiceDto){
        ServiceDto serviceDto = serviceService.updateService(serviceId, currentServiceDto);
        return ResponseEntity.ok(serviceDto);
    }

    @DeleteMapping("/api/v1/services/{Id}")
    public ResponseEntity<String> deleteService(@PathVariable("Id") Long serviceId){
        serviceService.deleteService(serviceId);
        return ResponseEntity.ok("Kullanıcı başarıyla silindi.");
    }
}
