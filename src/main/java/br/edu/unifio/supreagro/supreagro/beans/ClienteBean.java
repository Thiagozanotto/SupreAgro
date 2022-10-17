package br.edu.unifio.supreagro.supreagro.beans;
import br.edu.unifio.supreagro.supreagro.entidades.Categoria;
import br.edu.unifio.supreagro.supreagro.entidades.Cliente;
import br.edu.unifio.supreagro.supreagro.repositorios.ClienteRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import javax.faces.view.ViewScoped;
import java.util.List;

@Data @Component @ViewScoped
public class ClienteBean {

    private Cliente cliente;
    @Autowired
    private ClienteRepository clienteRepository;
    private List<Cliente> clientes;

    public void listar() {
        clientes = clienteRepository.findAll();
    }

    public void novo() { cliente = new Cliente(); }

    public void salvar() {
        try {
            clienteRepository.save(cliente);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("cliente-listagem.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalInfo("Esse Cliente já existe!");
        }
    }
}