package com.ProyectoDeExperienciasRegistro.Registro.Service.Cycles;

import com.ProyectoDeExperienciasRegistro.Registro.DAO.Cycles.CyclesDAO;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Cycles;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CyclesServiceImpl implements CyclesService{
    @Autowired
    public CyclesDAO cyclesDAO;
    @Override
    public Cycles save(Cycles cycles) {
        return cyclesDAO.save(cycles);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Cycles> findAll() {
        return cyclesDAO.findAll();
    }

    @Override
    public Optional<Cycles> findById(Long id) {
        return cyclesDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    cyclesDAO.deleteById(id);
    }
}
