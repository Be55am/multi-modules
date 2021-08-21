package com.goldminds.common.service;


import com.goldminds.common.dto.AbstractDTO;

public interface Removable<DTO extends AbstractDTO> {
	Void removeById(final long id);
}
