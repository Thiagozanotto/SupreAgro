package br.edu.unifio.supreagro.supreagro.repositorios;

import br.edu.unifio.supreagro.supreagro.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository <Usuario, Integer> {
}
