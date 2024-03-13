package app.entregafinal.controller;

import app.entregafinal.entity.Venda;
import app.entregafinal.service.VendaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Venda venda) {

        try {

            String mensagem = this.vendaService.save(venda);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Venda venda, @PathVariable int id) {

        try {

            String mensagem = this.vendaService.update(id, venda);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Venda>> listAll (){

        try {

            List<Venda> lista = this.vendaService.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/findById/{idVenda}")
    public ResponseEntity<Venda> findById(@PathVariable long idVenda){

        try {

            Venda venda = this.vendaService.findById(idVenda);
            return new ResponseEntity<>(venda, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{idVenda}")
    public ResponseEntity<String> delete(@PathVariable long idVenda){

        try {

            String mensagem = this.vendaService.delete(idVenda);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/findByVendaValorTotal")
    public ResponseEntity<?> findByVendaValorTotal (@RequestParam int valortotal){

        try {

            List<Venda> lista = this.vendaService.findByVendaValorTotal(valortotal);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
