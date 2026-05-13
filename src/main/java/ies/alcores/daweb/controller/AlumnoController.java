package ies.alcores.daweb.controller;

import ies.alcores.daweb.model.Alumno;
import ies.alcores.daweb.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@CrossOrigin
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> all(){
        return ResponseEntity.ok(this.alumnoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Alumno> findOne(@PathVariable final Long id) {
        return this.alumnoService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
