package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.Usuario;
import br.edu.unifio.supreagro.supreagro.repositorios.UsuarioRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@Data
@Component
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;

    private List<Usuario> usuarios;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void listar() {
        usuarios = usuarioRepository.findAll();
    }

    public void novo() {
        usuario = new Usuario();
    }

    public void salvar() {
        try {
            usuarioRepository.save(usuario);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("usuario-listagem.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalInfo("Esse Usuário já existe!");
        }
    }
}
