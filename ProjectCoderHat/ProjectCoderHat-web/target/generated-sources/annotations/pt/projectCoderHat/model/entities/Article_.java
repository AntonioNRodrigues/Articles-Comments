package pt.projectCoderHat.model.entities;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Article.class)
public abstract class Article_ {

	public static volatile SingularAttribute<Article, Integer> number;
	public static volatile SingularAttribute<Article, Date> dateInserction;
	public static volatile SingularAttribute<Article, String> contentArticle;
	public static volatile SingularAttribute<Article, Integer> id;
	public static volatile SingularAttribute<Article, String> nameArticle;

}

