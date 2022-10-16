package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.Categoria;
import br.edu.unifio.supreagro.supreagro.entidades.Usuario;
import br.edu.unifio.supreagro.supreagro.repositorios.CategoriaRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.UsuarioRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@Data @Component @ViewScoped
public class CategoriaBean {

    private Categoria categoria;

    private List<Categoria> categorias;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void listar() {
        categorias = categoriaRepository.findAll();
    }

    public void novo() { categoria = new Categoria(); }

    public void salvar() {
        try {
            categoriaRepository.save(categoria);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("categoria-listagem.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalInfo("Essa Categoria já existe!");
        }
    }
}

