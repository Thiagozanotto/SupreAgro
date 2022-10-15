package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.Usuario;
import br.edu.unifio.supreagro.supreagro.entidades.Veiculo;
import br.edu.unifio.supreagro.supreagro.entidades.Vendedor;
import br.edu.unifio.supreagro.supreagro.repositorios.UsuarioRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.VendedorRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@ViewScoped
@Component
@Data
public class VendedorBean {
    private Vendedor vendedor;

    private List<Vendedor> vendedorList;

    @Autowired private VendedorRepository vendedorRepository;

    private Usuario username;

    private Usuario senha;

    private List<Usuario> usuarioList;

    private UsuarioRepository usuarioRepository;

    public void listar(){
        vendedorList = vendedorRepository.findAll();
    }
    public void novo(){
        vendedor = new Vendedor();
    }
    public void salvar() {
        try {
            vendedorRepository.save(vendedor);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("veiculo-listagem.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Registro já existe!");
        }
    }


}
