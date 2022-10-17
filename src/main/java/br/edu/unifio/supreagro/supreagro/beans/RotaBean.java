package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.*;
import br.edu.unifio.supreagro.supreagro.repositorios.ClienteRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.RotaRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.VeiculoRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.VendedorRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import javax.faces.view.ViewScoped;
import java.util.List;
import java.util.ListResourceBundle;

@Data @Component @ViewScoped
public class RotaBean {

    private Rota rota;
    @Autowired
    private RotaRepository rotaRepository;
    private List<Rota> rotas;

    private List<Veiculo> veiculos;
    @Autowired private VeiculoRepository veiculoRepository;

    private List<Vendedor> vendedores;
    @Autowired private VendedorRepository vendedorRepository;

    private List<Cliente> clientes;
    @Autowired private ClienteRepository clienteRepository;

    public void listar(){ rotas = rotaRepository.findAll(); }

    public void novo(){
        rota = new Rota();
        veiculos = veiculoRepository.findAll();
        vendedores = vendedorRepository.findAll();
        clientes = clienteRepository.findAll();
    }

    public void salvar(){
        try{
            rotaRepository.save(rota);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("rota-listagem.xhtml?faces-redirect=true");
        }catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Registro já existe!");}
    }
}
