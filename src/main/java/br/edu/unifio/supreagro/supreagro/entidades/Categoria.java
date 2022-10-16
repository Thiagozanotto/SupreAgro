package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Categoria {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(nullable = false, unique = true)
private String nome;

@Column(nullable = false)
private String descricao;
}
