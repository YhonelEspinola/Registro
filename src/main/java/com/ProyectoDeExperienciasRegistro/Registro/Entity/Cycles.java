package com.ProyectoDeExperienciasRegistro.Registro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cycles")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cycles {
    @Id
    @SequenceGenerator(
            name = "cycles_sequence",
            sequenceName = "cycles_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cycles_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String numberCycles;

    @ManyToOne
    @JoinColumn(name = "id_cycles")
    private Student student;
}
