package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.*;
import br.edu.unifio.supreagro.supreagro.repositorios.ClienteRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.PedidoRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.VendedorRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@Data
@ViewScoped
@Component
public class PedidoBean {
    private Pedido pedido;

    private List<Pedido> pedidoList;
    private List<Cliente> clienteList;
    private List<Vendedor> vendedorList;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VendedorRepository vendedorRepository;


    public void listar(){
        pedidoList = pedidoRepository.findAll();
    }
    public void novo(){
        pedido = new Pedido();
        vendedorList = vendedorRepository.findAll();
        clienteList = clienteRepository.findAll();
    }
    public void salvar(){
        try{
            pedidoRepository.save(pedido);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("pedido-listagem.xhtml?faces-redirect=true");
        }catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Registro já existe!");}
    }

}