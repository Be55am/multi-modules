package com.goldminds.common.service;


import com.goldminds.common.dto.AbstractDTO;

public interface AbstractService<DTO extends AbstractDTO> extends
		Persistable<DTO>,
		Updatable<DTO>,
		Queryable<DTO>,
		Removable<DTO> {
}
