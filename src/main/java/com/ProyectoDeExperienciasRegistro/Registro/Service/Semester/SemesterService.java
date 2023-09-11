package com.ProyectoDeExperienciasRegistro.Registro.Service.Semester;


import com.ProyectoDeExperienciasRegistro.Registro.Entity.Semester;

import java.util.Optional;

public interface SemesterService {
    public Semester save(Semester semester);

    public Iterable<Semester>findAll();

    public Optional<Semester> findById(Long id);



    public void deleteById(Long id);
}
