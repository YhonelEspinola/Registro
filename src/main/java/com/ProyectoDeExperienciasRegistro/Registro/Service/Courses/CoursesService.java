package com.ProyectoDeExperienciasRegistro.Registro.Service.Courses;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Courses;

import java.util.Optional;

public interface CoursesService {
    public Courses save(Courses courses);

    public Iterable<Courses>findAll();

    public Optional<Courses> findById(Long id);



    public void deleteById(Long id);
}
