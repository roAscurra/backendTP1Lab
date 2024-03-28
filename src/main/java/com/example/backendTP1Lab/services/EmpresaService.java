package com.example.backendTP1Lab.services;

import com.example.backendTP1Lab.entities.Empresa;
import com.example.backendTP1Lab.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;
    //traer todas las empresas
    public List<Empresa> list(){
        return empresaRepository.findAll();
    }
    //eliminar
    public boolean deleteEmpresa(Integer id) throws Exception {
        try {
            if (empresaRepository.existsById(id)) {
                empresaRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
    //alta
    public Empresa save(Empresa empresa)throws Exception {
        try {
            empresa = empresaRepository.save(empresa);
            System.out.println("Estoy en servicio con el id generado:" + empresa.getId());

            System.out.println("Estoy en servicio  generado" + empresa.getDenominacion());

            return empresa;
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Empresa> findById(Integer id) throws Exception{
        try{
            return empresaRepository.findById(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    //consulta por denominacion
    public List<Empresa> findByDenominacion(String denominacion)throws Exception{
        try {
            return empresaRepository.findByDenominacion(denominacion);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    // Consulta por teléfono
    public List<Empresa> findByTelefono(String telefono) throws Exception {
        try {
            return empresaRepository.findByTelefono(telefono);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Consulta por horario de atención
    public List<Empresa> findByHorarioAtencion(String horarioAtencion) throws Exception {
        try {
            return empresaRepository.findByHorarioAtencion(horarioAtencion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Consulta por quienes somos
    public List<Empresa> findByQuienesSomos(String quienesSomos) throws Exception {
        try {
            return empresaRepository.findByQuienesSomos(quienesSomos);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Consulta por latitud
    public List<Empresa> findByLatitud(Double latitud) throws Exception {
        try {
            return empresaRepository.findByLatitud(latitud);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Consulta por longitud
    public List<Empresa> findByLongitud(Double longitud) throws Exception {
        try {
            return empresaRepository.findByLongitud(longitud);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Consulta por domicilio
    public List<Empresa> finByDomicilio(String domicilio) throws Exception {
        try {
            return empresaRepository.findByDomicilio(domicilio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Consulta por email
    public List<Empresa> finByEmail(String email) throws Exception {
        try {
            return empresaRepository.findByEmail(email);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
