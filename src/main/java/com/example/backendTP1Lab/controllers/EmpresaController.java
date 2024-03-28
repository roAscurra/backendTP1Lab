package com.example.backendTP1Lab.controllers;

import com.example.backendTP1Lab.entities.Empresa;
import com.example.backendTP1Lab.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Optional<Empresa>> obtenerEmpresaPorId(@PathVariable int id) throws Exception {
        try {
            Optional<Empresa> empresa = empresaService.findById(id);
            return empresa.isPresent() ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Endpoint para agregar una nueva empresa
    @PostMapping("/crear")
    public ResponseEntity<?> agregarEmpresa(@RequestBody Empresa empresa) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.save(empresa));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    // Endpoint para modificar una empresa existente
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarEmpresa(@PathVariable Integer id, @RequestBody Map<String, Object> cambios) {
        try {
            Empresa empresa = empresaService.modificarEmpresa(id, cambios);
            return ResponseEntity.ok(empresa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar la empresa: " + e.getMessage());
        }
    }

    // Endpoint para eliminar una empresa por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmpresa(@PathVariable Integer id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(empresaService.deleteEmpresa(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde. \"}");
        }
    }
    // Endpoint buscador
    @GetMapping("/buscar/{parametro}")
    public ResponseEntity<?> buscador(@PathVariable String parametro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.buscador(parametro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }
    // Consultar empresas por denominacion
    @GetMapping("/buscarPorDenominacion/{denominacion}")
    public ResponseEntity<?> buscarPorDenominacion(@PathVariable String denominacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.findByDenominacion(denominacion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }

    // Consultar empresas por teléfono
    @GetMapping("/buscarPorTelefono/{telefono}")
    public ResponseEntity<?> buscarEmpresasPorTelefono(@PathVariable String telefono) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.findByTelefono(telefono));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }



    // Consultar empresas por horario de atención
    @GetMapping("/buscarPorHorarioAtencion/{horarioAtencion}")
    public ResponseEntity<?> buscarEmpresasPorHorarioAtencion(@PathVariable String horarioAtencion) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.findByHorarioAtencion(horarioAtencion));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }

    }

    // Consultar empresas por quienes somos
    @GetMapping("/buscarPorQuienesSomos/{quienesSomos}")
    public ResponseEntity<?> buscarEmpresasPorQuienesSomos(@PathVariable String quienesSomos) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.findByQuienesSomos(quienesSomos));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }

    // Consultar empresas por latitud
    @GetMapping("/buscarPorLatitud/{latitud}")
    public ResponseEntity<?> buscarEmpresasPorLatitud(@PathVariable Double latitud) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.findByLatitud(latitud));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }

    // Consultar empresas por longitud
    @GetMapping("/buscarPorLongitud/{longitud}")
    public ResponseEntity<?> buscarEmpresasPorLongitud(@PathVariable Double longitud) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.findByLongitud(longitud));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }

    // Consultar empresas por domicilio
    @GetMapping("/buscarPorDomicilio/{domicilio}")
    public ResponseEntity<?> buscarEmpresasPorDomicilio(@PathVariable String domicilio) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.finByDomicilio(domicilio));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }

    // Consultar empresas por email
    @GetMapping("/buscarPorEmail/{email}")
    public ResponseEntity<?> buscarEmpresasPorEmail(@PathVariable String email) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.finByEmail(email));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }
    // Endpoint para obtener la denominación de una empresa por su ID
    @GetMapping("/denominacion/{id}")
    public ResponseEntity<String> obtenerDenominacion(@PathVariable int id) {
        try {
            String denominacion = empresaService.obtenerDenominacion(id);
            return ResponseEntity.ok(denominacion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }
    // Endpoint para obtener la domicilio de una empresa por su ID
    @GetMapping("/domicilio/{id}")
    public ResponseEntity<String> obtenerDomicilio(@PathVariable int id) {
        try {
            String domicilio = empresaService.obtenerDomicilio(id);
            return ResponseEntity.ok(domicilio);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }
    // Endpoint para obtener la email de una empresa por su ID
    @GetMapping("/email/{id}")
    public ResponseEntity<String> obtenerEmail(@PathVariable int id) {
        try {
            String email = empresaService.obtenerEmail(id);
            return ResponseEntity.ok(email);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }
    // Endpoint para obtener la horario de atencion de una empresa por su ID
    @GetMapping("/horarioAtencion/{id}")
    public ResponseEntity<String> obtenerHorarioAtencionPorId(@PathVariable int id) {
        try {
            String horarioAtencion = empresaService.obtenerHorarioAtencion(id);
            return ResponseEntity.ok(horarioAtencion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }
    // Endpoint para obtener latitud de una empresa por su ID
    @GetMapping("/latitud/{id}")
    public ResponseEntity<?> obtenerLatitud(@PathVariable int id) {
        try {
            Double latitud = empresaService.obtenerLatitudPorId(id);
            return ResponseEntity.ok(latitud);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    // Endpoint para obtener longitud de una empresa por su ID
    @GetMapping("/longitud/{id}")
    public ResponseEntity<?> obtenerLongitud(@PathVariable int id) {
        try {
            Double longitud = empresaService.obtenerLongitud(id);
            return ResponseEntity.ok(longitud);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    // Endpoint para obtener quienes somos de una empresa por su ID
    @GetMapping("/quienesSomos/{id}")
    public ResponseEntity<String> obtenerQuienesSomos(@PathVariable int id) {
        try {
            String quienesSomos = empresaService.obtenerQuienesSomos(id);
            return ResponseEntity.ok(quienesSomos);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }
    // Endpoint para obtener telefono de una empresa por su ID
    @GetMapping("/telefono/{id}")
    public ResponseEntity<String> obtenerTelefono(@PathVariable int id) {
        try {
            String horarioAtencion = empresaService.obtenerTelefono(id);
            return ResponseEntity.ok(horarioAtencion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage()+"\"}"));
        }
    }
}
