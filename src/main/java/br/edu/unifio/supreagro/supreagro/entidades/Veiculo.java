package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity @Data
public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String ano = "2022";

    @ManyToOne
    @JoinColumn(nullable = false)
    private Vendedor vendedor;
}
