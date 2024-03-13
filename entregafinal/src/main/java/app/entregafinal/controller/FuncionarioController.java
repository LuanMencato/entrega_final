package app.entregafinal.controller;

import app.entregafinal.entity.Cliente;
import app.entregafinal.entity.Funcionario;
import app.entregafinal.service.ClienteService;
import app.entregafinal.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/funcionario")
@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;


    @PostMapping("/save")
    ResponseEntity<String> save(@RequestBody Funcionario funcionario) {
        try {

            String mensagem = this.funcionarioService.save(funcionario);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<String>("Erro:"+e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Funcionario funcionario, @PathVariable int id) {

        try {

            String mensagem = this.funcionarioService.update(id, funcionario);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<String>("Erro:" + e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<Funcionario>> listAll (){
        try {

            List<Funcionario> lista =this.funcionarioService.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/findById/{idFuncionario}")
    public ResponseEntity<Funcionario> findById(@PathVariable long idFuncionario){

        try{
            Funcionario funcionario = this.funcionarioService.findById(idFuncionario);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{idFuncionario}")
    public ResponseEntity<String> delete(@PathVariable long idFuncionario){

        try {
            String mensagem = this.funcionarioService.delete(idFuncionario);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Erro"+e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Funcionario>> findByNome (@RequestParam String nome){

        try {

            List<Funcionario> lista = this.funcionarioService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMatricula")
    public ResponseEntity<List<Funcionario>> findByMatricula (@RequestParam int matricula){

        try {

            List<Funcionario> lista = this.funcionarioService.findByMatricula(matricula);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }
}
