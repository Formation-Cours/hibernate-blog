package fr.webforce.services;

import fr.webforce.Config;
import fr.webforce.entities.ArticleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Calendar;
import java.util.Collection;
import java.util.Optional;

public class ArticleService {
	private final Session session = Config.build().openSession();

	public Collection<ArticleEntity> findAll() {
		return session.createQuery("FROM ArticleEntity").getResultList();
	}
	public Collection<ArticleEntity> findAllNoDeleted() {
		return session.createQuery("FROM ArticleEntity WHERE dateDeleted IS NULL").getResultList();
	}

	public Optional<ArticleEntity> findByID(Integer id) {
		Query<ArticleEntity> q = session.createQuery("FROM ArticleEntity WHERE id = :id");
		q.setParameter("id", id);
		return q.uniqueResultOptional();
	}

	public void save(ArticleEntity art) {
		if (art.getId() == null){
			art.setDateCreated(Calendar.getInstance());
		} else {
			art.setDateUpdated(Calendar.getInstance());
		}
		Transaction tx = session.beginTransaction();
		session.merge(art);
		tx.commit();
	}

	public void delete(ArticleEntity art) {
		art.setDateDeleted(Calendar.getInstance());
		Transaction tx = session.beginTransaction();
		session.merge(art);
		tx.commit();
	}

}
