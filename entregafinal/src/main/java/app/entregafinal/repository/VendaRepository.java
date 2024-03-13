package app.entregafinal.repository;

import app.entregafinal.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
//        boolean existsByEnderecoEntrega(String endereco);

//        @Query("SELECT v FROM Venda v WHERE v.valorTotal < :valorTotal")
        public List<Venda> findByValorTotal( int valorTotal);
}
