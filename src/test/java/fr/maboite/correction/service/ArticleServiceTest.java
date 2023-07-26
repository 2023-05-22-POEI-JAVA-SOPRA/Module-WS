package fr.maboite.correction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.entity.Article;

public class ArticleServiceTest {

	private ArticleService articleService = new ArticleService();
	
	@Test
	public void testSave() throws Exception {
		
		Article article = new Article();
		
		Article savedArticle = this.articleService.save(article);
		
		Assertions.assertNotNull(savedArticle);
		Assertions.assertNotNull(savedArticle.getIdArticle());
		
	}
	
}
