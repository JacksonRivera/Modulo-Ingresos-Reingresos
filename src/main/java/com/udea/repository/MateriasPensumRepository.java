package com.udea.repository;

import com.udea.domain.MateriasPensum;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MateriasPensum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MateriasPensumRepository extends JpaRepository<MateriasPensum, Long> {}
