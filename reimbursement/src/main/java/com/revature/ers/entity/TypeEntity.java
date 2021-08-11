package com.revature.ers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQuery(
		name = "typename",
		query = "call typename()",
		resultClass = TypeEntity.class
)
@Entity
@Table(name = "Type")
public class TypeEntity {

	@Id
	@Column(nullable=false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
