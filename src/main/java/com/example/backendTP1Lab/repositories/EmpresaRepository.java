package com.example.backendTP1Lab.repositories;

import com.example.backendTP1Lab.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    public List<Empresa> findByDenominacion(String denominacion);
    public List<Empresa> findByTelefono(String telefono);
    public List<Empresa> findByHorarioAtencion(String horaAtencion);
    public List<Empresa> findByQuienesSomos(String quienesSomos);
    public List<Empresa> findByLatitud(Double latitud);
    public List<Empresa> findByLongitud(Double longitud);
    public List<Empresa> findByDomicilio(String domicilio);
    public List<Empresa> findByEmail(String email);

}
