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
    private List<Vendedor> vendedores;
    @Autowired private VendedorRepository vendedorRepository;

    private List<Usuario> usuarios;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void listar(){
        vendedores = vendedorRepository.findAll();
    }
    public void novo(){
        vendedor = new Vendedor();
        usuarios = usuarioRepository.findAll();
    }
    public void salvar() {
        try {
            vendedorRepository.save(vendedor);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("vendedor-listagem.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Registro já existe!");
        }
    }


    public void carregar(){
        vendedor = Faces.getFlashAttribute("cursor");
    }


}
