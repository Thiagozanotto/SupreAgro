package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column
    private String senha;

    @Column(nullable = false)
    private String tipo;

}
