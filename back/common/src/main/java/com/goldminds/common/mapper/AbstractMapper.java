package com.goldminds.common.mapper;

import java.io.Serializable;

/**
 * @author bessam on 21/08/2021
 */

public interface AbstractMapper<E extends Serializable, T> {

	T toDTO(E entity);

	E toEntity(T dto);
}
