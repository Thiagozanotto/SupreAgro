package br.edu.unifio.supreagro.supreagro.repositorios;

import br.edu.unifio.supreagro.supreagro.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
