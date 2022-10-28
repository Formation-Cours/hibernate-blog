package fr.webforce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class ArticleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	private String title;

	@Column(unique = true)
	@NonNull
	private String slug;

	@Column(columnDefinition = "text")
	@NonNull
	private String body;

	@NonNull
	private String author;

	@Column(name = "date_created")
	private Calendar dateCreated;

	@Column(name = "date_published")
	private Calendar datePublished;

	@Column(name = "date_updated")
	private Calendar dateUpdated;

	@Column(name = "date_deleted")
	private Calendar dateDeleted;

	@ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private CategoryEntity category;

	public ArticleEntity(Integer id) {
		this.id = id;
	}
}
