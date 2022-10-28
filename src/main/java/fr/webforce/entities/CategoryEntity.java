package fr.webforce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CategoryEntity {
	@Id
	private Integer id;

	@Column(length = 64, unique = true, nullable = false)
	private String name;
}
