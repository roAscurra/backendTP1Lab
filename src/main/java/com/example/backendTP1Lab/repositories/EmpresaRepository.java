package com.example.backendTP1Lab.repositories;

import com.example.backendTP1Lab.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    @Query("SELECT e FROM Empresa e WHERE LOWER(e.denominacion) LIKE %:denominacion%")
    public List<Empresa> findByDenominacion(String denominacion);
    @Query("SELECT e FROM Empresa e WHERE LOWER(e.telefono) LIKE %:telefono%")
    public List<Empresa> findByTelefono(String telefono);
    @Query("SELECT e FROM Empresa e WHERE LOWER(e.horarioAtencion) LIKE %:horaAtencion%")
    public List<Empresa> findByHorarioAtencion(String horaAtencion);
    @Query("SELECT e FROM Empresa e WHERE LOWER(e.quienesSomos) LIKE %:quienesSomos%")
    public List<Empresa> findByQuienesSomos(String quienesSomos);
    @Query("SELECT e FROM Empresa e WHERE CAST(e.latitud AS string) LIKE %:latitud%")
    public List<Empresa> findByLatitud(Double latitud);
    @Query("SELECT e FROM Empresa e WHERE CAST(e.longitud AS string) LIKE %:longitud%")
    public List<Empresa> findByLongitud(Double longitud);
    @Query("SELECT e FROM Empresa e WHERE LOWER(e.domicilio) LIKE %:domicilio%")
    public List<Empresa> findByDomicilio(String domicilio);
    @Query("SELECT e FROM Empresa e WHERE LOWER(e.email) LIKE %:email%")
    public List<Empresa> findByEmail(String email);

}
