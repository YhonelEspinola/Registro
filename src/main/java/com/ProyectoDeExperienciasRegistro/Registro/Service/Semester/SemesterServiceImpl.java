package com.ProyectoDeExperienciasRegistro.Registro.Service.Semester;

import com.ProyectoDeExperienciasRegistro.Registro.DAO.Semester.SemesterDAO;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Semester;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SemesterServiceImpl implements SemesterService{
    @Autowired
    public SemesterDAO semesterDAO;
    @Override
    public Semester save(Semester semester) {
        return semesterDAO.save(semester);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Semester> findAll() {
        return semesterDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Semester> findById(Long id) {
        return semesterDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    semesterDAO.deleteById(id);
    }
}
