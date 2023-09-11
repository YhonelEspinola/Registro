package com.ProyectoDeExperienciasRegistro.Registro.DAO.Student;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student,Long> {


}
