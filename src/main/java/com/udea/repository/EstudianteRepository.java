package com.udea.repository;

import com.udea.domain.Estudiante;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Estudiante entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    public Estudiante findByCorreo(String correo);

    public List<Estudiante> findByEstado(String estado);

    public List<Estudiante> findByGenero(String genero);
}
