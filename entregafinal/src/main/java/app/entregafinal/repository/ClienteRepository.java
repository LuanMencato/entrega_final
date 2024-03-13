package app.entregafinal.repository;

import app.entregafinal.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    List<Cliente> findByCpf(String cpf);

    List<Cliente> findByNome(String nome);

    List<Cliente> findByTelefone(String telefone);
    List<Cliente> findByIdade(int idade);
    @Query(value = "SELECT COUNT(c) > 0 FROM Cliente c WHERE 18 <= :idade AND c.nome = :nome")
    boolean avaliaMaioridade(@RequestParam("idade")int idade, @RequestParam("nome") String nome);

}
