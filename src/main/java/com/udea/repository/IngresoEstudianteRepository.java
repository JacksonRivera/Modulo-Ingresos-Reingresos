package com.udea.repository;

import com.udea.domain.IngresoEstudiante;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the IngresoEstudiante entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IngresoEstudianteRepository extends JpaRepository<IngresoEstudiante, Long> {
    public List<IngresoEstudiante> findByTipoIngreso(String tipoIngreso);

    public IngresoEstudiante findByCarrera(Long id);
}
