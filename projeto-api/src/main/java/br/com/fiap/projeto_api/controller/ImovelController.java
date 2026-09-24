package br.com.fiap.projeto_api.controller;

import br.com.fiap.projeto_api.dao.ImovelDao;
import br.com.fiap.projeto_api.model.Imovel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("imoveis")
public class ImovelController {


    private ImovelDao dao;

    public ImovelController(ImovelDao dao){
        this.dao = dao;
    }

    @PostMapping("adicionar")
    public ResponseEntity<Imovel>adicionar(@RequestBody Imovel imovel,
                                           UriComponentsBuilder Builder) throws SQLException{
        dao.inserir(imovel);

        URI uri = Builder.path("/imoveis/{id}")
                .buildAndExpand(imovel.getId()).toUri();

        return ResponseEntity.created(uri).body(imovel);
    }

    @GetMapping
    public List<Imovel>listar() throws SQLException{
        return dao.listar();

    }

}
