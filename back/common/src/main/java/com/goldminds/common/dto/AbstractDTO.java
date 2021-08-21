package com.goldminds.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author bessam on 21/08/2021
 */

@Data
public abstract class AbstractDTO {

	private Long id;

	private LocalDateTime createdAt;

	private LocalDateTime updateAt;

}
