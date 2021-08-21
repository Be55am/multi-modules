package com.goldminds.common.service;


import com.goldminds.common.dto.AbstractDTO;

import java.util.List;

public interface Persistable<DTO extends AbstractDTO> {

	DTO save(final DTO dto);

	List<DTO> saveAll(final Iterable<DTO> list);
}
