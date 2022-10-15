package br.edu.unifio.supreagro.supreagro.entidades;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Categoria {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

private String nome;

private String descricao;
}
