package app.entregafinal.controller;


import app.entregafinal.entity.Cliente;
import app.entregafinal.entity.Venda;
import app.entregafinal.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    ResponseEntity<String> save(@RequestBody Cliente cliente) {
        try {

            String mensagem = this.clienteService.save(cliente);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<String>("Erro:"+e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save-more")
    ResponseEntity<String> save(@RequestBody List<Cliente> clientes) {
        try {

            String mensagem = this.clienteService.saveMore(clientes);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<String>("Erro:"+e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping ("/update/{id}")
        public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable int id) {

        try {

            String mensagem = this.clienteService.update(id, cliente);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<String>("Erro:" + e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<Cliente>> listAll (){
            try {

                List<Cliente> lista =this.clienteService.listAll();
                return new ResponseEntity<>(lista, HttpStatus.OK);

            } catch (Exception e){

                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            }
        }
    @GetMapping("/findById/{idCliente}")
    public ResponseEntity<?> findById(@PathVariable long idCliente){

        try{
            Cliente cliente = this.clienteService.findById(idCliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<String> delete(@PathVariable long idCliente){

        try {
             String mensagem = this.clienteService.delete(idCliente);
             return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Erro"+e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Cliente>> findByNome (@RequestParam String nome){

        try {

            List<Cliente> lista = this.clienteService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e){

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByClienteTelefone")
    public ResponseEntity<List<Cliente>> findByClienteTelefone (@RequestParam String telefone){

        try {

            List<Cliente> lista = this.clienteService.findByClienteTelefone(telefone);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/findByClienteCpf")
    public ResponseEntity<List<Cliente>> findByClienteCpf (@RequestParam String cpf){

        try {

            List<Cliente> lista = this.clienteService.findByClienteCpf(cpf);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/findByClienteIdade")
    public ResponseEntity<List<Cliente>> findByClienteIdade (@RequestParam int idade){

        try {

            List<Cliente> lista = this.clienteService.findByClienteIdade(idade);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

}
