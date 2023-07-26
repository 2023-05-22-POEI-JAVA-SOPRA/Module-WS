package fr.maboite.correction.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.entity.Article;

public class ArticleServiceTest {
	
	ArticleService service = new ArticleService();
	
	@Test
	public void getbyid_article_with_non_existing_id() {
		assertNull(service.getById(100));
	}
	
	@Test
	public void getById_article_with_existing_id() {
		Article uTest = new Article("haut de gamme", "Rolex", 2500);
		assertEquals(uTest, service.getById(1));
	}
	
	

	@Test
	public void delete_article_with_non_existing_id() {
		assertEquals(service.delete(5785), false);
	}
	
	@Test
	public void create_article_with_null_description() {
		Article a = new Article(null, "123456", 5162651);
		assertFalse(service.create(a));
	}
	
	@Test
	public void create_article_with_null_brand() {
		Article a = new Article("very cheap", null, 5162651);
		assertFalse(service.create(a));
	}
	
	/*
	 * @Test public void create_article_with_null_price() { Article a = new
	 * Article("nice", "nana", (Float) null); assertFalse(service.create(a)); }
	 */

	@Test
	public void create_article_with_description_size_sup_to_20() {
		Article a = new Article("haut degammehaut de gammehaut de gammehaut de gammevhaut de gammekkkkkk", "Ferrari", 5162651);
		assertFalse(service.create(a));
	}
	
	@Test
	public void create_article_with_brand_size_sup_to_30() {
		Article a = new Article("voiture", "jjjjjjjjjjjjjjhaut de gammehaut de gammehaut de gammehaut de gammevhaut de gamme", 5162651);
		assertFalse(service.create(a));
	}
	
	@Test
	public void create_valid_article() {
		Article a = new Article("test@test.com", "testtest", 5162651);
		assertTrue(service.create(a));
	}

}
