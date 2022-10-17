package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

   @Column
   private String observacao;

    @Column private Double ValorTotal;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Vendedor vendedor;


}
