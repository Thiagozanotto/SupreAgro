package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vendedor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

   @Column private String nome;

   @Column private String endereco;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
}
