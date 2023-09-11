package com.ProyectoDeExperienciasRegistro.Registro.Controller.Semester;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Semester;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Teacher;
import com.ProyectoDeExperienciasRegistro.Registro.Service.Semester.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/semester")
@CrossOrigin(origins = "http://localhost:3000")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    @PostMapping
    public ResponseEntity<Semester> create (@RequestBody Semester semester){
        return ResponseEntity.status(HttpStatus.CREATED).body(semesterService.save(semester));
    }
    @GetMapping
    public List<Semester> readAll(){
        List<Semester> semesters= StreamSupport
                .stream(semesterService.findAll().spliterator(),false).collect(Collectors.toList());
        return semesters;
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Semester> update(@RequestBody Semester semesterDetalle,@PathVariable Long id){
        Optional<Semester> semesters=semesterService.findById(id);
        if (!semesters.isPresent()){
            return ResponseEntity.notFound().build();
        }
        semesters.get().setOneSemester(semesterDetalle.getOneSemester());
        semesters.get().setTwoSemester(semesterDetalle
                .getTwoSemester());

        return ResponseEntity.status(HttpStatus.CREATED).body(semesterService.save(semesters.get()));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(!semesterService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        semesterService.deleteById(id);
        return  ResponseEntity.ok("El curso a sido eliminado");
    }
}
