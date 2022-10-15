package br.edu.unifio.supreagro.supreagro.repositorios;

import br.edu.unifio.supreagro.supreagro.entidades.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}
