package app.entregafinal.controller;

import app.entregafinal.entity.Produto;
import app.entregafinal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Produto produto) {

        try {

            String mensagem = this.produtoService.save(produto);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Produto produto, @PathVariable int id) {

        try {

            String mensagem = this.produtoService.update(id, produto);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Produto>> listAll (){

        try {

            List<Produto> lista = this.produtoService.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/findById/{idProduto}")
    public ResponseEntity<Produto> findById(@PathVariable long idProduto){

        try {

            Produto produto = this.produtoService.findById(idProduto);
            return new ResponseEntity<>(produto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{idProduto}")
    public ResponseEntity<String> delete(@PathVariable long idProduto){

        try {

            String mensagem = this.produtoService.delete(idProduto);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>("erro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }



    @GetMapping("/findByNome")
    public ResponseEntity<List<Produto>> findByNome (@RequestParam String nome){

        try {

            List<Produto> lista = this.produtoService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/findByProdutoValor")
    public ResponseEntity<List<Produto>> findByMarcaNome (@RequestParam int valor){

        try {

            List<Produto> lista = this.produtoService.findByProdutoValor(valor);
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }


}
