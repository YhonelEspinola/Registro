package com.ProyectoDeExperienciasRegistro.Registro.Service.Modality;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Modality;

import java.util.Optional;

public interface ModalityService {
    public Modality save(Modality modality);

    public Iterable<Modality>findAll();

    public Optional<Modality> findById(Long id);



    public void deleteById(Long id);
}
