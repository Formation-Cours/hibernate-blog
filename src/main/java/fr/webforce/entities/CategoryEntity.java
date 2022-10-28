package fr.webforce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 64, unique = true, nullable = false)
	private String name;

	@OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "category")
	private Collection<ArticleEntity> articles;
}
