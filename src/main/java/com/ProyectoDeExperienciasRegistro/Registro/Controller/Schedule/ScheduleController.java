package com.ProyectoDeExperienciasRegistro.Registro.Controller.Schedule;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Courses;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Schedule;
import com.ProyectoDeExperienciasRegistro.Registro.Service.Schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/schedules")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> readAll(){
        List<Schedule> schedules= StreamSupport
                .stream(scheduleService.findAll().spliterator(), false).collect(Collectors.toList());
        return schedules ;
    }
    @PostMapping
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(schedule));
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Schedule> update(@RequestBody Schedule scheduleDetalle, @PathVariable Long id){
        Optional<Schedule> schedules= scheduleService.findById(id);
        if (!schedules.isPresent()){
            return ResponseEntity.notFound().build();
        }
        schedules.get().setMorning(scheduleDetalle.getMorning());
        schedules.get().setAfternoon(scheduleDetalle.getAfternoon());
        schedules.get().setNight(scheduleDetalle.getNight());


        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(schedules.get()));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(!scheduleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        scheduleService.deleteById(id);
        return ResponseEntity.ok("El horario a sido eliminado correctamente");
    }

}
