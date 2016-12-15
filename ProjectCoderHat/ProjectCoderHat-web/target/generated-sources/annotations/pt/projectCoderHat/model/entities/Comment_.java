package pt.projectCoderHat.model.entities;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comment.class)
public abstract class Comment_ {

	public static volatile SingularAttribute<Comment, Date> dateComment;
	public static volatile SingularAttribute<Comment, String> nameAuthor;
	public static volatile SingularAttribute<Comment, String> nameComment;
	public static volatile SingularAttribute<Comment, Integer> id;

}

