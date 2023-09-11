package com.ProyectoDeExperienciasRegistro.Registro.Service.Student;

import com.ProyectoDeExperienciasRegistro.Registro.DAO.Student.StudentDAO;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService{
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public Student save(Student student) {

        return studentDAO.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    studentDAO.deleteById(id);
    }

}
