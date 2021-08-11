package com.revature.ers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQuery(
		name = "designationname",
		query = "call designationname()",
		resultClass = DesignationEntity.class
)
@Entity
@Table(name = "Designation")
public class DesignationEntity {
	
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
