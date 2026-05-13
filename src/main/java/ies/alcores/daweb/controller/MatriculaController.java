package ies.alcores.daweb.controller;

import ies.alcores.daweb.model.Matricula;
import ies.alcores.daweb.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matricula")
@CrossOrigin
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<Matricula>> all(){
        return ResponseEntity.ok(this.matriculaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Matricula> findOne(@PathVariable("id") final long id){
        return this.matriculaService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
