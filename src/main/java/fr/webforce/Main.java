package fr.webforce;

import fr.webforce.entities.ArticleEntity;
import fr.webforce.entities.CategoryEntity;
import fr.webforce.services.ArticleService;
import fr.webforce.services.CategoryService;

import java.util.Collection;
import java.util.Optional;

public class Main {

	static ArticleService articleService = new ArticleService();
	static CategoryService categoryService = new CategoryService();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello world!");

		ArticleEntity art1 = new ArticleEntity(
				"Article 1",
				"article-1",
				"Je suis un article.",
				"Samuel MICHAUX");

		CategoryEntity cat1 = new CategoryEntity(null, "maison");
		cat1 = categoryService.save(cat1);

		art1.setCategory(cat1);

		articleService.save(art1);

		Collection<ArticleEntity> articles = articleService.findAll();
		System.out.println(articles);
	}

	private static void insert() {
		ArticleEntity art1 = new ArticleEntity(
				"Article 1",
				"article-1",
				"Je suis un article.",
				"Samuel MICHAUX");

		ArticleEntity art2 = new ArticleEntity(
				"Article 2",
				"article-2",
				"Je suis un article de second rang",
				"Samuel MICHAUX");

		ArticleEntity art3 = new ArticleEntity(
				"Article 3",
				"article-3",
				"Je suis un article de troisième rang.",
				"Samuel MICHAUX");

		ArticleEntity art4 = new ArticleEntity(
				"Article 4",
				"article-4",
				"Tu es qui pour définir que je suis un article.",
				"Samuel MICHAUX");

		articleService.save(art1);
		articleService.save(art2);
		articleService.save(art3);
		articleService.save(art4);
	}
}
