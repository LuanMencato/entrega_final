package app.entregafinal.service;

import app.entregafinal.entity.Produto;
import app.entregafinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public String save(Produto produto) {
        this.produtoRepository.save(produto);
        return produto.getNome()+ " salvo";
    }

    public String update(long id, Produto produto) {
        produto.setId(id);
        this.produtoRepository.save(produto);
        return produto.getNome()+ " atualizado";
    }

    public List<Produto> listAll(){
        return this.produtoRepository.findAll();
    }

    public Produto findById(long idProduto) {

        Produto produto = this.produtoRepository.findById(idProduto).get();
        return produto;

    }

    public String delete(long idProduto) {
        this.produtoRepository.deleteById(idProduto);
        return "produto deletado!";

    }

    public List<Produto> findByProdutoValor(int valor){
        return this.produtoRepository.findByValor(valor);
    }

    public List<Produto> findByNome(String nome){
        return this.produtoRepository.findByNome(nome);
    }

}
