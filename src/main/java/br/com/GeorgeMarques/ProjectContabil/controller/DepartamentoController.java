package br.com.GeorgeMarques.ProjectContabil.controller;

import br.com.GeorgeMarques.ProjectContabil.model.Departamento;
import br.com.GeorgeMarques.ProjectContabil.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        List<Departamento> departamentos = departamentoService.getAllDepartamentos();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable("id") Long id) {
        Departamento departamento = departamentoService.getDepartamentoById(id);
        if (departamento != null) {
            return new ResponseEntity<>(departamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento) {
        Departamento createdDepartamento = departamentoService.createDepartamento(departamento);
        return new ResponseEntity<>(createdDepartamento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable("id") Long id) {
        departamentoService.deleteDepartamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
