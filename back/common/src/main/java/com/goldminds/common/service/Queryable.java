package com.goldminds.common.service;

import com.goldminds.common.dto.AbstractDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface Queryable<DTO extends AbstractDTO> {

	List<DTO> findAll();

	DTO findById(final long id);

	Page<DTO> findAll(final Pageable pageable);
}
