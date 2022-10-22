package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String observacao;

    @Column
    private String valortotal;

    @Column
    @ManyToOne
    private Cliente cliente;
}
