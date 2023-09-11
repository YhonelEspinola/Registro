package com.ProyectoDeExperienciasRegistro.Registro.Controller.Courses;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Courses;

import com.ProyectoDeExperienciasRegistro.Registro.Service.Courses.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping
    public List<Courses> readAll(){
        List<Courses> course= StreamSupport
                .stream(coursesService.findAll().spliterator(), false).collect(Collectors.toList());
        return course ;
    }
    @PostMapping
    public ResponseEntity<Courses> create(@RequestBody Courses courses){
        return ResponseEntity.status(HttpStatus.CREATED).body(coursesService.save(courses));
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Courses> update(@RequestBody Courses coursesDetalle, @PathVariable Long id){
        Optional<Courses> course= coursesService.findById(id);
        if (!course.isPresent()){
            return ResponseEntity.notFound().build();
        }
        course.get().setName(coursesDetalle.getName());


        return ResponseEntity.status(HttpStatus.CREATED).body(coursesService.save(course.get()));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(!coursesService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        coursesService.deleteById(id);
        return ResponseEntity.ok("Se elimino correctamente el curso");
    }


}
