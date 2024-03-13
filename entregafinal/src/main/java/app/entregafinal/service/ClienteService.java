package app.entregafinal.service;

import app.entregafinal.entity.Cliente;
import app.entregafinal.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public String save(Cliente cliente) {
        this.clienteRepository.save(cliente);
        return cliente.getNome() + " salvo!";
    }

    public String saveMore(List<Cliente> clientes) throws Exception{

        for(Cliente cliente: clientes){
            if(cliente.getNome() == null || cliente.getNome().isBlank()){
                throw new Exception("Cliente invalido");
            }

            clienteRepository.save(cliente);
        }
        return "Salvo com sucesso";
    }

    public String update(long id, Cliente cliente) {
        cliente.setId(id);
        this.clienteRepository.save(cliente);
        return cliente.getNome()+ " atualizado!";
    }

    public List<Cliente> listAll(){
        return this.clienteRepository.findAll();
    }

    public Cliente findById(long idCliente) throws EntityNotFoundException, Exception{
        Cliente clienteDoBanco = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Erro ao buscar cliente"));

        if(clienteRepository.avaliaMaioridade(clienteDoBanco.getIdade(), clienteDoBanco.getNome())){
            return clienteDoBanco;
        } else {
            throw new Exception("O cliente eh menor de idade");
        }
    }

    public String delete(long idCliente) {
        this.clienteRepository.deleteById(idCliente);
        return "Cliente deletado!";

    }

    public List<Cliente> findByNome(String nome){
        return this.clienteRepository.findByNome(nome);
    }

    public List<Cliente> findByClienteCpf(String cpf){
        return this.clienteRepository.findByCpf(cpf);
    }


    public List<Cliente> findByClienteTelefone(String telefone){
        return this.clienteRepository.findByTelefone(telefone);
    }

    public List<Cliente> findByClienteIdade(int idade){
        return this.clienteRepository.findByIdade(idade);
    }
}
