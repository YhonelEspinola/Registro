package com.ProyectoDeExperienciasRegistro.Registro.Service.Schedule;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Schedule;

import java.util.Optional;

public interface ScheduleService {
    public Schedule save(Schedule schedule);

    public Iterable<Schedule>findAll();

    public Optional<Schedule>findById(Long id);



    public void deleteById(Long id);
}
