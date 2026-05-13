package ies.alcores.daweb.controller;

import ies.alcores.daweb.model.Asignatura;
import ies.alcores.daweb.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
@CrossOrigin
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public ResponseEntity<List<Asignatura>> all(){
        return ResponseEntity.ok(this.asignaturaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Asignatura> findOne(@PathVariable("id") final long id){
        return this.asignaturaService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
