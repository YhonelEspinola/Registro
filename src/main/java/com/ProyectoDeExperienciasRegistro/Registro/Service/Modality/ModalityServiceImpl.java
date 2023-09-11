package com.ProyectoDeExperienciasRegistro.Registro.Service.Modality;

import com.ProyectoDeExperienciasRegistro.Registro.DAO.Modality.ModalityDAO;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Modality;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModalityServiceImpl implements ModalityService{
    @Autowired
    public ModalityDAO modalityDAO;

    @Override
    public Modality save(Modality modality) {
        return modalityDAO.save(modality);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Modality> findAll() {
        return modalityDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Modality> findById(Long id) {
        return modalityDAO.findById(id);
    }


    @Override
    public void deleteById(Long id) {
    modalityDAO.deleteById(id);
    }
}
