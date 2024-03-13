package app.entregafinal.repository;

import app.entregafinal.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByValor(int valor);

    public List<Produto> findByNome(String nome);
}
