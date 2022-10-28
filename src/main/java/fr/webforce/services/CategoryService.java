package fr.webforce.services;

import fr.webforce.Config;
import fr.webforce.entities.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryService {

	private final Session session = Config.build().openSession();

	public CategoryEntity save(CategoryEntity cat) {
		Transaction tx = session.beginTransaction();
		cat = session.merge(cat);
		tx.commit();
		return cat;
	}
}
