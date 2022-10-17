package br.edu.unifio.supreagro.supreagro.repositorios;

import br.edu.unifio.supreagro.supreagro.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
