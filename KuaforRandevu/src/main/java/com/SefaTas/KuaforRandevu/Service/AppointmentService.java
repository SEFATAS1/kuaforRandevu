package com.SefaTas.KuaforRandevu.Service;

import com.SefaTas.KuaforRandevu.Dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> findAllAppointments();
    AppointmentDto createAppointment(AppointmentDto appointmentDto);
    AppointmentDto updateAppointment(Long appointmentId, AppointmentDto updateAppointment);
    //AppointmentDto updateAppointmentState(Long appointmentId, AppointmentDto updateAppointment);
}
