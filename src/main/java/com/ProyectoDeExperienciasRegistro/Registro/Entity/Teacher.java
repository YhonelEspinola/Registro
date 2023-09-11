package com.ProyectoDeExperienciasRegistro.Registro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Teacher")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String admissionDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teachers", cascade = CascadeType.ALL)
    private List<Courses> courses;

    @ManyToMany(mappedBy = "teachers")
    private List<Student> students;

}
