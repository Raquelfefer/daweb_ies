package ies.alcores.daweb.controller;

import ies.alcores.daweb.model.Profesor;
import ies.alcores.daweb.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesor")
@CrossOrigin
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public ResponseEntity<List<Profesor>> all(){
        return ResponseEntity.ok(this.profesorService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Profesor> findOne(@PathVariable("id") final long id){
        return this.profesorService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
