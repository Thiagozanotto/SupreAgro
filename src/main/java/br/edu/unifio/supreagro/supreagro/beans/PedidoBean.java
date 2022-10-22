package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.*;
import br.edu.unifio.supreagro.supreagro.repositorios.ClienteRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.PedidoRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.ProdutoRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.VendedorRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data @ViewScoped @Component
public class PedidoBean implements Serializable {
    private Pedido pedido;

    private List<Pedido> pedidos;
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<Produto> carrinho;
    private List<Produto> produtos;

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    VendedorRepository vendedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void listar(){
        pedidos = pedidoRepository.findAll();
    }
    public void novo(){
        pedido = new Pedido();
        vendedores = vendedorRepository.findAll();
        clientes = clienteRepository.findAll();
        produtos = produtoRepository.findAll();
        carrinho = new ArrayList<>();
    }

    public void adcionar(Produto cursor){ carrinho.add(cursor); }
    public void salvar(){

        try {
            pedidoRepository.save(pedido);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("pedido-novo.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalInfo("Esse Pedido já existe!");
        }

        for (Produto produto : carrinho){

            PedidoItem item = new PedidoItem();
            item.setPedido(pedido);
            item.setProduto(produto);
            // item.setQuantidade(Byte.valueOf("1"));
            item.setPreco(produto.getPreco());

            pedido.getItens().add(item);
        }
        pedidoRepository.save(pedido);
        Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
        Faces.navigate("pedido-novo.xhtml?faces-redirect=true");
    }
}