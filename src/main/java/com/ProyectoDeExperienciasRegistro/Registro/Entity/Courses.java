package com.ProyectoDeExperienciasRegistro.Registro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Courses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Courses {
    @Id
    @SequenceGenerator(
            name = "courses_sequence",
            sequenceName = "courses_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courses_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "Course_Schedule",
            joinColumns=@JoinColumn(name = "Courses_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id"))
    private List<Schedule> schedules;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "Course_Modality",
            joinColumns=@JoinColumn(name = "Courses_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Modality_id", referencedColumnName = "id"))
    private  List<Modality> Modality;

    @ManyToOne
    @JoinColumn(name = "id_teachers")
    private Teacher teachers;

    @ManyToMany(mappedBy = "courses")
    private  List<Student> students;

}
