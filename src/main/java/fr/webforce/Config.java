package fr.webforce;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Config {
	public static SessionFactory build() {
		return new Configuration().configure().buildSessionFactory();
	}
}
