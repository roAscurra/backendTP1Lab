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
    public void save(Empresa empresa){
        empresaRepository.save(empresa);
    }
    public Optional<Empresa> findById(Integer id){
        return empresaRepository.findById(id);
    }
    //consulta por denominacion
    public List<Empresa> findByDenominacion(String denominacion){
        return empresaRepository.findByDenominacion(denominacion);
    }
    //consulta por telefono
    public List<Empresa> findByNombre(String nombre){
        return empresaRepository.findByTelefono(nombre);
    }
    //consulta por horario de atencion
    public List<Empresa> finByHorarioAtencion(String horario){
        return empresaRepository.findByHorarioAtencion(horario);
    }
    //quienes somos
    public List<Empresa> findByQuienesSomos(String quienesSomos){
        return empresaRepository.findByQuienesSomos(quienesSomos);
    }
    public List<Empresa> findByLatitud(Double latitud){
        return empresaRepository.findByLatitud(latitud);
    }
    public List<Empresa> findByLongitud(Double longitud){
        return empresaRepository.findByLongitud(longitud);
    }
    public List<Empresa> finByDomicilio(String domicilio){
        return empresaRepository.findByDomicilio(domicilio);
    }
    public List<Empresa> finByEmail(String email){
        return empresaRepository.findByEmail(email);
    }
}
