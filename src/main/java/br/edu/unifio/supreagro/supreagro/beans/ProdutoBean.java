package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.Categoria;
import br.edu.unifio.supreagro.supreagro.entidades.Produto;
import br.edu.unifio.supreagro.supreagro.entidades.Veiculo;
import br.edu.unifio.supreagro.supreagro.repositorios.CategoriaRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.ProdutoRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@Data @Component @ViewScoped
public class ProdutoBean {

    private Produto produto;
    @Autowired
    private ProdutoRepository produtoRepository;
    private List<Produto> produtos;

    private List<Categoria> categorias;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void listar(){
        produtos = produtoRepository.findAll();
    }
    public void novo(){
        produto = new Produto();
        categorias = categoriaRepository.findAll();
    }
    public void salvar(){
        try{
            produtoRepository.save(produto);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("produto-listagem.xhtml?faces-redirect=true");
        }catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Registro já existe!");}
    }
}
