package app.entregafinal.repository;

import app.entregafinal.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public List<Funcionario> findByMatricula(int matricula);

    public List<Funcionario> findByNome(String nome);
}
