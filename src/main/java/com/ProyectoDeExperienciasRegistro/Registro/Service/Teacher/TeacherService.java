package com.ProyectoDeExperienciasRegistro.Registro.Service.Teacher;


import com.ProyectoDeExperienciasRegistro.Registro.Entity.Teacher;

import java.util.Optional;

public interface TeacherService
{
    public Teacher save(Teacher teachers);

    public Iterable<Teacher>findAll();

    public Optional<Teacher> findById(Long id);



    public void deleteById(Long id);
}
