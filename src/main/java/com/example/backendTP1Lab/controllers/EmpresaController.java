package com.example.backendTP1Lab.controllers;

import com.example.backendTP1Lab.entities.Empresa;
import com.example.backendTP1Lab.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/empresas")
public class EmpresaController {
    //inyeccion del servicio
    @Autowired
    private EmpresaService empresaService;

    // Endpoint para obtener todas las empresas
    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.list();
    }

    // Endpoint para obtener una empresa por su ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Empresa>> obtenerEmpresaPorId(@PathVariable int id) {
        Optional<Empresa> empresa = empresaService.findById(id);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para agregar una nueva empresa
    @PostMapping
    public ResponseEntity<Void> agregarEmpresa(@RequestBody Empresa empresa) {
        empresaService.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Endpoint para actualizar una empresa existente
    @PutMapping("/update/{id}")


    // Endpoint para eliminar una empresa por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(empresaService.deleteEmpresa(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde. \"}");
        }
    }
}
