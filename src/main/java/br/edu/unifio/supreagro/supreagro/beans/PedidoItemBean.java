package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.Cliente;
import br.edu.unifio.supreagro.supreagro.entidades.Pedido;
import br.edu.unifio.supreagro.supreagro.entidades.PedidoItem;
import br.edu.unifio.supreagro.supreagro.repositorios.ClienteRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.PedidoItemRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.PedidoRepository;
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
public class PedidoItemBean {
private PedidoItem pedidoItem;

private List<PedidoItem> pedidoItemList;
private List<Pedido> pedidolist;
private List<Cliente> clienteList;

@Autowired private PedidoItemRepository pedidoItemRepository;
@Autowired private PedidoRepository pedidoRepository;
@Autowired private ClienteRepository clienteRepository;

    public void listar(){
        pedidoItemList = pedidoItemRepository.findAll();
    }
    public void novo(){
        pedidoItem = new PedidoItem();
        pedidolist = pedidoRepository.findAll();
        clienteList = clienteRepository.findAll();
    }
    public void salvar(){
        try{
            pedidoItemRepository.save(pedidoItem);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("pedido_item-listagem.xhtml?faces-redirect=true");
        }catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Registro já existe!");}
    }
}
