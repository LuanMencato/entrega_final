package app.entregafinal.service;

import app.entregafinal.entity.Funcionario;
import app.entregafinal.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public String save(Funcionario funcionario) {
        this.funcionarioRepository.save(funcionario);
        return funcionario.getNome()+ " salvo com sucesso";
    }

    public String update(long id, Funcionario funcionario) {
        funcionario.setId(id);
        this.funcionarioRepository.save(funcionario);
        return funcionario.getNome()+ " atualizado com sucesso";
    }

    public List<Funcionario> listAll(){
        return this.funcionarioRepository.findAll();
    }

    public Funcionario findById(long idFuncionario) {

        Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario).get();
        return funcionario;

    }

    public String delete(long idFuncionario) {
        this.funcionarioRepository.deleteById(idFuncionario);
        return "deletado com sucesso!";

    }

    public List<Funcionario> findByNome(String nome){
        return this.funcionarioRepository.findByNome(nome);
    }

    public List<Funcionario> findByMatricula(int matricula){
        return this.funcionarioRepository.findByMatricula(matricula);
    }


}
