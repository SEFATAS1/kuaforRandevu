package com.SefaTas.KuaforRandevu.Repository;

import com.SefaTas.KuaforRandevu.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
