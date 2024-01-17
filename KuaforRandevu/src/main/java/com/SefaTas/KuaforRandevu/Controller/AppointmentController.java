package com.SefaTas.KuaforRandevu.Controller;

import com.SefaTas.KuaforRandevu.Dto.AppointmentDto;
import com.SefaTas.KuaforRandevu.Service.AppointmentService;
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
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/api/v1/appointments")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto createdAppointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/appointments")
    public ResponseEntity<List<AppointmentDto>> findAllAppointments(){
        List<AppointmentDto> appointmentDtoList = appointmentService.findAllAppointments();
        return ResponseEntity.ok(appointmentDtoList);
    }

    @PutMapping("/api/v1/appointments/{Id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable("Id") Long appointmentId, @RequestBody AppointmentDto currentAppointmentDto){
        AppointmentDto appointmentDto = appointmentService.updateAppointment(appointmentId, currentAppointmentDto);
        return ResponseEntity.ok(appointmentDto);
    }

    /*@PutMapping("{Id}")
    public ResponseEntity<AppointmentDto> updateAppointmentState(@PathVariable("Id") Long appointmentId, @RequestBody AppointmentDto currentAppointmentDto){
        AppointmentDto appointmentDto = appointmentService.updateAppointmentState(appointmentId, currentAppointmentDto);
        return ResponseEntity.ok(appointmentDto);
    }*/
}
