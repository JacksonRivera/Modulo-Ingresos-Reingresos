package com.udea.web.rest;

import com.udea.domain.Estudiante;
import com.udea.repository.EstudianteRepository;
import com.udea.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.udea.domain.Estudiante}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class EstudianteResource {

    private final Logger log = LoggerFactory.getLogger(EstudianteResource.class);

    private static final String ENTITY_NAME = "estudiante";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EstudianteRepository estudianteRepository;

    public EstudianteResource(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    /**
     * {@code POST  /estudiantes} : Create a new estudiante.
     *
     * @param estudiante the estudiante to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new estudiante, or with status {@code 400 (Bad Request)} if the estudiante has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/estudiantes")
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) throws URISyntaxException {
        log.debug("REST request to save Estudiante : {}", estudiante);
        if (estudiante.getId() != null) {
            throw new BadRequestAlertException("A new estudiante cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Estudiante result = estudianteRepository.save(estudiante);
        return ResponseEntity
            .created(new URI("/api/estudiantes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /estudiantes/:id} : Updates an existing estudiante.
     *
     * @param id the id of the estudiante to save.
     * @param estudiante the estudiante to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated estudiante,
     * or with status {@code 400 (Bad Request)} if the estudiante is not valid,
     * or with status {@code 500 (Internal Server Error)} if the estudiante couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Estudiante estudiante
    ) throws URISyntaxException {
        log.debug("REST request to update Estudiante : {}, {}", id, estudiante);
        if (estudiante.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, estudiante.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!estudianteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Estudiante result = estudianteRepository.save(estudiante);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, estudiante.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /estudiantes/:id} : Partial updates given fields of an existing estudiante, field will ignore if it is null
     *
     * @param id the id of the estudiante to save.
     * @param estudiante the estudiante to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated estudiante,
     * or with status {@code 400 (Bad Request)} if the estudiante is not valid,
     * or with status {@code 404 (Not Found)} if the estudiante is not found,
     * or with status {@code 500 (Internal Server Error)} if the estudiante couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/estudiantes/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Estudiante> partialUpdateEstudiante(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Estudiante estudiante
    ) throws URISyntaxException {
        log.debug("REST request to partial update Estudiante partially : {}, {}", id, estudiante);
        if (estudiante.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, estudiante.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!estudianteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Estudiante> result = estudianteRepository
            .findById(estudiante.getId())
            .map(existingEstudiante -> {
                if (estudiante.getNombre() != null) {
                    existingEstudiante.setNombre(estudiante.getNombre());
                }
                if (estudiante.getApellido() != null) {
                    existingEstudiante.setApellido(estudiante.getApellido());
                }
                if (estudiante.getFechaNacimiento() != null) {
                    existingEstudiante.setFechaNacimiento(estudiante.getFechaNacimiento());
                }
                if (estudiante.getCorreo() != null) {
                    existingEstudiante.setCorreo(estudiante.getCorreo());
                }
                if (estudiante.getDireccion() != null) {
                    existingEstudiante.setDireccion(estudiante.getDireccion());
                }
                if (estudiante.getEstado() != null) {
                    existingEstudiante.setEstado(estudiante.getEstado());
                }
                if (estudiante.getDocumento() != null) {
                    existingEstudiante.setDocumento(estudiante.getDocumento());
                }
                if (estudiante.getGenero() != null) {
                    existingEstudiante.setGenero(estudiante.getGenero());
                }
                if (estudiante.getNumeroContacto() != null) {
                    existingEstudiante.setNumeroContacto(estudiante.getNumeroContacto());
                }

                return existingEstudiante;
            })
            .map(estudianteRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, estudiante.getId().toString())
        );
    }

    /**
     * {@code GET  /estudiantes} : get all the estudiantes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of estudiantes in body.
     */
    @GetMapping("/estudiantes")
    public List<Estudiante> getAllEstudiantes() {
        log.debug("REST request to get all Estudiantes");
        return estudianteRepository.findAll();
    }

    /**
     * {@code GET  /estudiantes/:id} : get the "id" estudiante.
     *
     * @param id the id of the estudiante to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the estudiante, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> getEstudiante(@PathVariable Long id) {
        log.debug("REST request to get Estudiante : {}", id);
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(estudiante);
    }

    //Metodo que trae la información de los estudiantes en base a su correo
    @GetMapping("/estudiantes/correo/{correo}")
    public Estudiante getEstudianteCorreo(@PathVariable String correo) {
        Estudiante Estudiante = estudianteRepository.findByCorreo(correo);
        return Estudiante;
    }

    //Metodo que trae la informacion de los estdiantes en base a su estado
    @GetMapping("/estudiantes/estado/{estado}")
    public List<Estudiante> getEstudianteEstado(@PathVariable String estado) {
        List<Estudiante> Estudiante = estudianteRepository.findByEstado(estado);
        return Estudiante;
    }

    //Metodo que trae la informacion de los estdiantes en base a su genero
    @GetMapping("/estudiantes/genero/{genero}")
    public List<Estudiante> getEstudianteGenero(@PathVariable String genero) {
        List<Estudiante> Estudiante = estudianteRepository.findByGenero(genero);
        return Estudiante;
    }

    /**
     * {@code DELETE  /estudiantes/:id} : delete the "id" estudiante.
     *
     * @param id the id of the estudiante to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        log.debug("REST request to delete Estudiante : {}", id);
        estudianteRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
