package com.ProyectoDeExperienciasRegistro.Registro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "modality")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Modality {
    @Id
    @SequenceGenerator(
            name = "modality_sequence",
            sequenceName = "modality_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "modality_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String type;


    @ManyToMany(mappedBy = "Modality")
    private List<Courses> courses;
}
