package com.goldminds.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * @author bessam on 21/08/2021
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@MappedSuperclass
@Data
public abstract class User extends AbstractEntity<Long> {

	private String login;

	private String password;

	private boolean activated;

}
