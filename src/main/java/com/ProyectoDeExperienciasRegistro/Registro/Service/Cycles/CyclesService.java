package com.ProyectoDeExperienciasRegistro.Registro.Service.Cycles;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Cycles;

import java.util.Optional;

public interface CyclesService {
    public Cycles save(Cycles cycles);

    public Iterable<Cycles>findAll();

    public Optional<Cycles>findById(Long id);

    public void deleteById(Long id);
}
