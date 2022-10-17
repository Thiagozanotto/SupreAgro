package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PedidoItem {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

@Column private Integer quantidade;

@Column private Integer valorunitario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pedido pedido;







}
