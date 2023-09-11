package com.ProyectoDeExperienciasRegistro.Registro.Service.Courses;

import com.ProyectoDeExperienciasRegistro.Registro.DAO.Courses.CoursesDAO;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Courses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService{

    @Autowired
    public CoursesDAO coursesDAO;
    @Override
    public Courses save(Courses courses) {
        return coursesDAO.save(courses);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Courses> findAll() {
        return coursesDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Courses> findById(Long id) {
        return coursesDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    coursesDAO.deleteById(id);
    }


}
