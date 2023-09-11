package com.ProyectoDeExperienciasRegistro.Registro.Controller.Teacher;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Teacher;
import com.ProyectoDeExperienciasRegistro.Registro.Service.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/teacher")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> create (@RequestBody Teacher teacher){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacher));
    }
    @GetMapping
    public List<Teacher> readAll(){
        List<Teacher> teachers= StreamSupport
                .stream(teacherService.findAll().spliterator(),false).collect(Collectors.toList());
                return teachers;
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Teacher> update(@RequestBody Teacher teacherDetalle,@PathVariable Long id){
        Optional<Teacher> teachers=teacherService.findById(id);
        if (!teachers.isPresent()){
            return ResponseEntity.notFound().build();
        }
        teachers.get().setName(teacherDetalle.getName());
        teachers.get().setLastName(teacherDetalle.getLastName());
        teachers.get().setAge(teacherDetalle.getAge());
        teachers.get().setAdmissionDate(teacherDetalle.getAdmissionDate());
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teachers.get()));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(!teacherService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        teacherService.deleteById(id);
        return  ResponseEntity.ok("El profesor fue elimiando correctamente");
    }

}
