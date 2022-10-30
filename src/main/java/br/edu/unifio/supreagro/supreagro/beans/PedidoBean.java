package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.*;
import br.edu.unifio.supreagro.supreagro.repositorios.ClienteRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.PedidoRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.ProdutoRepository;
import br.edu.unifio.supreagro.supreagro.repositorios.VendedorRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data @ViewScoped @Component
public class PedidoBean implements Serializable {
    private Pedido pedido;
    private List<Pedido> pedidos;
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<Produto> carrinho;
    private List<Produto> produtos;
    private Produto produto;

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
            Faces.navigate("pedido-listagem.xhtml?faces-redirect=true");
            pedido.setValortotal(String.valueOf(resul));
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
    public void carregarFoto(FileUploadEvent event) {
        UploadedFile arquivo = event.getFile();
        pedido.setFoto(arquivo.getContent());
        Messages.addFlashGlobalInfo("Arquivo carregado com sucesso");
    }

    double resul = 0;
    Double valor = 0D;
    public void calcular(){
        valor = 0D;

        for (Produto produto : carrinho) {
            valor += produto.getPreco();
        }
    }
    public void excluir() {
        try {
            pedidoRepository.delete(pedido);
            Messages.addFlashGlobalInfo("Registro removido com sucesso!");
            Faces.navigate("pedido-listagem.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao){
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Essa Categoria possui produtos vinculados!");
        }
    }

    public void selecionarExclusao(Pedido cursor){
        Faces.setFlashAttribute("cursor", cursor);
        Faces.navigate("pedido-exclusao.xhtml?faces-redirect=true");
    }
    public void selecionarEdicao(Pedido cursor){
        Faces.setFlashAttribute("cursor", cursor);
        Faces.navigate("pedido-edicao.xhtml?faces-redirect=true");
    }

    public void carregar(){
        pedido = Faces.getFlashAttribute("cursor");
        clientes = clienteRepository.findAll();
        vendedores = vendedorRepository.findAll();
        produtos = produtoRepository.findAll();
    }
}
