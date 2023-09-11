package com.ProyectoDeExperienciasRegistro.Registro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Schedule")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Schedule {
    @Id
    @SequenceGenerator(
            name = "schedule_sequence",
            sequenceName = "schedule_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "schedule_sequence"
    )
    private Long id;
    @Column(nullable = false, unique = true)
    private String morning;
    @Column(nullable = false, unique = true)
    private String afternoon;
    @Column(nullable = false, unique = true)
    private String night;

    @ManyToMany(mappedBy = "schedules")
    private List<Courses> courses;
}
