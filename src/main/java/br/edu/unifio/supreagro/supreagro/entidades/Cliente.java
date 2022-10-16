package br.edu.unifio.supreagro.supreagro.entidades;
import lombok.Data;
import javax.persistence.*;
@Data @Entity
public class Cliente {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
}
