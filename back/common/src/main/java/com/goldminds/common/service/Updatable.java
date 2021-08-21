package com.goldminds.common.service;


import com.goldminds.common.dto.AbstractDTO;

public interface Updatable<DTO extends AbstractDTO> {
	DTO update(final DTO dto);
}
