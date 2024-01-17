package com.SefaTas.KuaforRandevu.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    private Long barberId;
    private Long customerId;
    private Long serviceId;
    private Date appointmentDate;
    private Date startTime;
    private Date endTime;
    private String note;
    private String appointmentStatus;
}
