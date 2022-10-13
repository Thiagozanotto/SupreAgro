package br.edu.unifio.supreagro.supreagro.beans;

import br.edu.unifio.supreagro.supreagro.entidades.Veiculo;
import br.edu.unifio.supreagro.supreagro.repositorios.VeiculoRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@Component @ViewScoped @Data
public class VeiculoBean {

    //priavte List<Vendedor> vendedores;
    //private VendedorRepository vendedorRepository;

    private Veiculo veiculo;
    private List<Veiculo> veiculos;
    @Autowired
    private VeiculoRepository veiculoRepository;

    public void listar(){
        veiculos = veiculoRepository.findAll();
    }
    public void novo(){
        veiculo = new Veiculo();
        //vendedores =  vendedorRepository.findAll();
    }
    public void salvar(){
        try{
            veiculoRepository.save(veiculo);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("veiculo-listagem.xhtml?faces-redirect=true");
        }catch (DataIntegrityViolationException excecao) {
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Registro já existe!");}
    }
}
