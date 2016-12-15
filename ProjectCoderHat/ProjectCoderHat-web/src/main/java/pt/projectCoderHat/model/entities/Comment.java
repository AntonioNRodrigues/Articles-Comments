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

/**
 *
 * @author Antonio Rodrigues
 */
@Entity
@Table(name = "Comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dateComment", nullable = true)
    private Date dateComment;

    @Column(name = "nameComment", length = 400, nullable = false)
    private String nameComment;

    @Column(name = "nameAuthor", length = 80, nullable = true)
    private String nameAuthor;

    public Comment() {
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    public String getNameComment() {
        return nameComment;
    }

    public void setNameComment(String nameComment) {
        this.nameComment = nameComment;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.dateComment);
        hash = 43 * hash + Objects.hashCode(this.nameComment);
        hash = 43 * hash + Objects.hashCode(this.nameAuthor);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateComment, other.dateComment)) {
            return false;
        }
        if (!Objects.equals(this.nameComment, other.nameComment)) {
            return false;
        }
        if (!Objects.equals(this.nameAuthor, other.nameAuthor)) {
            return false;
        }
        return true;
    }

}
