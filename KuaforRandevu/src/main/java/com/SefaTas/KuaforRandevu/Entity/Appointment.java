package com.SefaTas.KuaforRandevu.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
