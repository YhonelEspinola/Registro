package com.ProyectoDeExperienciasRegistro.Registro.Service.Schedule;

import com.ProyectoDeExperienciasRegistro.Registro.DAO.Schedule.ScheduleDAO;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    public ScheduleDAO scheduleDAO;

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleDAO.save(schedule);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Schedule> findAll() {
        return scheduleDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Schedule> findById(Long id) {
        return scheduleDAO.findById(id);
    }


    @Override
    public void deleteById(Long id) {
        scheduleDAO.deleteById(id);
    }
}
