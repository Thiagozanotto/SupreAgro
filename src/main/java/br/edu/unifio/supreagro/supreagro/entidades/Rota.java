package br.edu.unifio.supreagro.supreagro.entidades;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data @Entity
public class Rota {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private LocalDateTime hora;

    @ManyToOne @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne @JoinColumn(nullable = false)
    private Vendedor vendedor;

    @ManyToOne @JoinColumn(nullable = false)
    private Veiculo veiculo;
}
