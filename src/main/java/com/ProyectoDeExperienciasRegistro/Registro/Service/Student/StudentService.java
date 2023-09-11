package com.ProyectoDeExperienciasRegistro.Registro.Service.Student;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Student;

import java.util.Optional;

public interface StudentService {
    public Student save(Student student);

    public Iterable<Student> findAll();

    public Optional<Student> findById(Long id);

    public void deleteById(Long id);


}
