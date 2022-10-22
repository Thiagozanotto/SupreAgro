package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String observacao;

    @Column
    private String valortotal;

    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.PERSIST})
    private List<PedidoItem> itens = new ArrayList<>();

    @ManyToOne @JoinColumn(nullable = false)
    private Cliente cliente;
    @ManyToOne @JoinColumn(nullable = false)
    private Vendedor vendedor;
}
