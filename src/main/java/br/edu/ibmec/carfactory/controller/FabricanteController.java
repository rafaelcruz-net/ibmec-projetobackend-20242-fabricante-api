package br.edu.ibmec.carfactory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ibmec.carfactory.model.Fabricante;
import br.edu.ibmec.carfactory.model.Modelo;
import br.edu.ibmec.carfactory.repository.FabricanteRepository;
import br.edu.ibmec.carfactory.repository.ModeloRepository;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

    @Autowired
    private FabricanteRepository repository;

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping
    public ResponseEntity<List<Fabricante>> obterTodos() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fabricante> obterPorId(@PathVariable("id") int id) {
        Optional<Fabricante> optFabricante = this.repository.findById(id);

        if (optFabricante.isPresent() == false)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(optFabricante.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Fabricante> create(@RequestBody Fabricante fabricante) {
        
        if (fabricante.getVeiculos() != null && fabricante.getVeiculos().size() > 0) {
            for (Modelo item : fabricante.getVeiculos()) {
                this.modeloRepository.save(item);
            }
        }

        this.repository.save(fabricante);
        return new ResponseEntity<>(fabricante, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Fabricante> excluir(@PathVariable("id") int id) {
        Optional<Fabricante> optFabricante = this.repository.findById(id);

        if (optFabricante.isPresent() == false)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        repository.delete(optFabricante.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
