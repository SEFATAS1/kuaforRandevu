package com.SefaTas.KuaforRandevu.Service.Impl;

import com.SefaTas.KuaforRandevu.Dto.AppointmentDto;
import com.SefaTas.KuaforRandevu.Entity.Appointment;
import com.SefaTas.KuaforRandevu.Exception.SourceNotFoundException;
import com.SefaTas.KuaforRandevu.Mapper.AppointmentMapper;
import com.SefaTas.KuaforRandevu.Repository.AppointmentRepository;
import com.SefaTas.KuaforRandevu.Service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentDto> findAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map((appointment -> AppointmentMapper.mapToAppointmentDto(appointment))).collect(Collectors.toList());
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = AppointmentMapper.mapToAppointment(appointmentDto);
        Appointment createdAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.mapToAppointmentDto(createdAppointment);
    }

    @Override
    public AppointmentDto updateAppointment(Long appointmentId, AppointmentDto updateAppointment) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new SourceNotFoundException("Girilen id ile ilişkili bir kayıt bulunanmadı. Id: " + appointmentId));

        appointment.setBarberId(updateAppointment.getBarberId());
        appointment.setCustomerId(updateAppointment.getCustomerId());
        appointment.setServiceId(updateAppointment.getServiceId());
        appointment.setAppointmentDate(updateAppointment.getAppointmentDate());
        appointment.setStartTime(updateAppointment.getStartTime());
        appointment.setEndTime(updateAppointment.getEndTime());

        Appointment updateAppointmentInDatabase = appointmentRepository.save(appointment);

        return AppointmentMapper.mapToAppointmentDto(updateAppointmentInDatabase);
    }
}
