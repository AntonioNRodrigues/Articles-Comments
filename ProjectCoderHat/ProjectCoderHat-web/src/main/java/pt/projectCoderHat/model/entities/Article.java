/*
 */
package pt.projectCoderHat.model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio Rodrigues
 */
@Entity
@Table(name = "Article")
@XmlRootElement
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "numero", nullable = true)
    private Integer number;

    @Column(name = "nameArticle", length = 100, nullable = false)
    private String nameArticle;

    @Column(name = "contentArticle", length = 400, nullable = false)
    private String contentArticle;

    @Column(name = "dateInserction", nullable = true)
    private Date dateInserction;

    // @OneToMany(mappedBy = "Article", fetch = FetchType.LAZY)
    //@ForeignKey (name = "article")
    //private List<Comment> comments;
    //private Integer numberComments;
    
    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return contentArticle;
    }

    public void setContent(String content) {
        this.contentArticle = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public Date getDateInserction() {
        return dateInserction;
    }

    public void setDateInserction(Date dateInserction) {
        this.dateInserction = dateInserction;
    }

    /*  public List<Comment> getComments() {
     return comments;
     }

     public void setComments(List<Comment> comments) {
     this.comments = comments;
     }

     public Integer getNumberComments() {
     return getComments().size();
     }

     public void setNumberComments(Integer numberComments) {
     this.numberComments = numberComments;
     }
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.number);
        hash = 37 * hash + Objects.hashCode(this.nameArticle);
        hash = 37 * hash + Objects.hashCode(this.dateInserction);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        if (!Objects.equals(this.nameArticle, other.nameArticle)) {
            return false;
        }
        if (!Objects.equals(this.dateInserction, other.dateInserction)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", number=" + number
                + ", nameArticle=" + nameArticle + ", dateInserction="
                + dateInserction + '}';
    }

}
