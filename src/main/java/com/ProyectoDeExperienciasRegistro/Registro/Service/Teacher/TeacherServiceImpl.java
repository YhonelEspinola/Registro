package com.ProyectoDeExperienciasRegistro.Registro.Service.Teacher;

import com.ProyectoDeExperienciasRegistro.Registro.DAO.Teacher.TeacherDAO;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    public TeacherDAO teacherDAO;
    @Override
    public Teacher save(Teacher teachers) {
        return teacherDAO.save(teachers);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Teacher> findById(Long id) {
        return teacherDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    teacherDAO.deleteById(id);
    }
}
