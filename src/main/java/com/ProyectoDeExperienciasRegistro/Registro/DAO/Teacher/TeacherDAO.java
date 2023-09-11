package com.ProyectoDeExperienciasRegistro.Registro.DAO.Teacher;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {
}
