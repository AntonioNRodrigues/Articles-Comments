/*
 */
package pt.projectCoderHat.model.mbeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pt.projectCoderHat.model.DAO.HibernateDAO;
import pt.projectCoderHat.model.DAO.HibernateInter;
import pt.projectCoderHat.model.entities.Article;
import pt.projectCoderHat.model.util.MyFacesContext;

/**
 *
 * @author Antonio Rodrigues
 */
@ManagedBean(name = "manBeanArticle")
@RequestScoped
public class ManBeanArticle implements Serializable {

    private static final long serial = 1L;
    private Article article;
    private List<Article> articlesList;

    public ManBeanArticle() {
        article = new Article();
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Article> getArticlesList() {
        return articleDAO().getEntities();
    }

    public void setArticlesList(List<Article> articlesList) {
        this.articlesList = articlesList;
    }

    public void createArticle() {
        if (article.getId() != null) {
            updateArticle();
        } else {
            managerDates();
            articleDAO().save(article);
            feedback("Article posted with success");
        }
    }

    public void deleteArticle() {
        articleDAO().remove(article);
        feedback("Article deleted with success");
    }

    public void updateArticle() {
        articleDAO().update(article);
        feedback("Article updated with success");
    }

    public void readArticle() {
        //userDAO().update(article);
    }

    private void feedback(String str) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, str, ""));
    }

    private HibernateInter<Article> articleDAO() {
        return new HibernateDAO<>(Article.class,
                MyFacesContext.getRequestSession());
    }

    private void managerDates() {
        java.util.Date now = new java.util.Date();
        java.sql.Date sqlDate = new Date(now.getTime());
        article.setDateInserction(sqlDate);
    }

}
