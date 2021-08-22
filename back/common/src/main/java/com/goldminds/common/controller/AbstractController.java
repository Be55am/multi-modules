package com.goldminds.common.controller;

import com.goldminds.common.Util.ResponseUtil;
import com.goldminds.common.dto.AbstractDTO;
import com.goldminds.common.service.AbstractService;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author bessam on 21/08/2021
 */


//todo trying to figure out how to make it more dynamic
public abstract class AbstractController<DTO extends AbstractDTO, SERVICE extends AbstractService<DTO>> {

	public SERVICE service;
	private Logger log;
//	private final Logger log = LoggerFactory.getLogger("Abstract Controller ");


	/**
	 * {@code GET  /:id} : get the entity id.
	 *
	 * @param id the id of the DTO to retrieve.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the addressDTO, or with status {@code 404 (Not Found)}.
	 */
	@GetMapping("/{id}")
	ResponseEntity<DTO> findById(@PathVariable Long id) {
		log.debug("REST request to get Entity : {}", id);
		Optional<DTO> dto = service.findById(id);
		return ResponseUtil.wrapOrNotFound(dto);
	}


	/**
	 * {@code GET  /habitations} : get all the entities.
	 *
	 * @param pageable the pagination information.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of habitations in body.
	 */
	@GetMapping("/pages")
	ResponseEntity<Page<DTO>> findAll(Pageable pageable) {
		log.debug("REST request to get a page of entities");
		return ResponseEntity.ok(service.findAll(pageable));
	}

	/**
	 * {@code POST  /habitations} : Create a new entity.
	 *
	 * @param entity the entity to create.
	 * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new habitationDTO, or with status {@code 400 (Bad Request)} if the entity has already an ID.
	 * @throws ResponseStatusException if the Location URI syntax is incorrect.
	 */

	@PostMapping
	public ResponseEntity<DTO> save(@RequestBody DTO entity) throws ResponseStatusException, URISyntaxException {
		log.debug("REST request to save Habitation : {}", entity);
		if (entity.getId() != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "THE ID SHOULD BE NULL");
		} else {
			DTO result = service.save(entity);
			return ResponseEntity
					.created(new URI("/" + result.getId()))
					.body(result);
		}

	}

	/**
	 * {@code PUT  /:id} : Updates an existing entity.
	 *
	 * @param id     the id of the entity to save.
	 * @param entity the entity to update.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entity,
	 * or with status {@code 400 (Bad Request)} if the entity is not valid,
	 * or with status {@code 500 (Internal Server Error)} if the entity couldn't be updated.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<DTO> update(@PathVariable Long id, @RequestBody DTO entity) throws URISyntaxException {
		log.debug("REST request to update Address : {}, {}", id, entity);
		if (entity.getId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INVALID ID");
		}
		if (!Objects.equals(id, entity.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INVALID ID");
		}

		if (!service.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ENTITY WITH ID " + id + " IS NOT FOUND !");
		}

		DTO result = service.save(entity);
		return ResponseEntity
				.created(new URI("/" + result.getId()))
				.body(result);
	}

	/**
	 * {@code DELETE  /:id} : delete the "id" entity.
	 *
	 * @param id the id of the entity to delete.
	 * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		log.debug("REST request to delete Entity : {}", id);
		service.removeById(id);
		return ResponseEntity
				.noContent()
				.build();
	}


}
