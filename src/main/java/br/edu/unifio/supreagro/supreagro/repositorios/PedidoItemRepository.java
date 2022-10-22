package br.edu.unifio.supreagro.supreagro.repositorios;

import br.edu.unifio.supreagro.supreagro.entidades.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem,Integer> {
}
