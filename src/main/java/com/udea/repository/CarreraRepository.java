package com.udea.repository;

import com.udea.domain.Carrera;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Carrera entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    public Carrera findByIdAndFacultad(Long id, String nombreFacultad);

    public List<Carrera> findByFacultad(String nombreFacultad);
}
