package com.ProyectoDeExperienciasRegistro.Registro.Controller.Student;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Student;
import com.ProyectoDeExperienciasRegistro.Registro.Service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }
    @GetMapping
    public List<Student> readAll(){
        List<Student> student= StreamSupport
                .stream(studentService.findAll().spliterator(), false).collect(Collectors.toList());
        return student;
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Student> students=studentService.findById(id);
        if(students.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(students);
    }

    @PutMapping(path = "{id}")
        public ResponseEntity<Student> update(@RequestBody Student studentDetalle, @PathVariable Long id){
         Optional<Student> students= studentService.findById(id);
         if (!students.isPresent()){
             return ResponseEntity.notFound().build();
         }
    students.get().setName(studentDetalle.getName());
         students.get().setLastname(studentDetalle.getLastname());
         students.get().setAge(studentDetalle.getAge());
         students.get().setAdmissiondate(studentDetalle.getAdmissiondate());
         students.get().setDatebirth(studentDetalle.getDatebirth());
         students.get().setGrade(studentDetalle.getGrade());
         students.get().setSection(studentDetalle.getSection());

         return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(students.get()));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!studentService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteById(id);
        return ResponseEntity.ok("El estudiante a sido eliminado correctamente");
    }

}
