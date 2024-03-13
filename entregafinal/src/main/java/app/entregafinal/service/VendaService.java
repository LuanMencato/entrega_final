package app.entregafinal.service;

import app.entregafinal.entity.Venda;
import app.entregafinal.repository.VendaRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public String save(Venda venda) throws Exception{

//        if(vendaRepository.existsByEnderecoEntrega(venda.getEnderecoEntrega())){
//            throw new Exception("Este endereco ja existe no banco");
//        }

        this.vendaRepository.save(venda);
        return venda.getValorTotal()+ " salvo";
    }

    public String update(long id, Venda venda) {
        venda.setId(id);
        this.vendaRepository.save(venda);
        return venda.getValorTotal()+ " atualizado";
    }

    public List<Venda> listAll(){
        return this.vendaRepository.findAll();
    }

    public Venda findById(long idVenda) {

        Venda venda = this.vendaRepository.findById(idVenda).get();
        return venda;

    }

    public String delete(long idVenda) {
        this.vendaRepository.deleteById(idVenda);
        return "Venda deletada!";

    }

    public List<Venda> findByVendaValorTotal(int valorTotal){
        return this.vendaRepository.findByValorTotal(valorTotal);
    }
}
