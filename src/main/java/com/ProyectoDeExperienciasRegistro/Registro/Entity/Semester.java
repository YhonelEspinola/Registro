package com.ProyectoDeExperienciasRegistro.Registro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Semester")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Semester {
    @Id
    @SequenceGenerator(
            name = "semester_sequence",
            sequenceName = "semester_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "semester_sequence"
    )
    private Long id;
    @Column(nullable = false, unique = true)
    private String oneSemester;
    @Column(nullable = false, unique = true)
    private String twoSemester;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "semester", cascade = CascadeType.ALL)
    private List<Student> students;
}
