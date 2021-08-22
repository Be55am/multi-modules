package com.goldminds.common.service;

import com.goldminds.common.dto.AbstractDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface Queryable<DTO extends AbstractDTO> {

	List<DTO> findAll();

	Optional<DTO> findById(final long id);

	Page<DTO> findAll(final Pageable pageable);

	boolean existsById(Long id);
}
