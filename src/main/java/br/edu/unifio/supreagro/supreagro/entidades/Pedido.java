package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime horario = LocalDateTime.now();

    @Column
    private String observacao;

    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.PERSIST})
    private List<PedidoItem> pedidoItems = new ArrayList<>();

    @Column
    private Double ValorTotal;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Vendedor vendedor;


}
