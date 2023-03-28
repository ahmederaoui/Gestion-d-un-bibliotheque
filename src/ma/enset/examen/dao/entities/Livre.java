package ma.enset.examen.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Livre implements Serializable {
    private int id;
    private String titre;
    private String isbn;
    private Date dateE;
    private List<Emprunt> emprunts;

    public Livre() {
        this.emprunts = new ArrayList<>();
    }

    public Livre( String titre, String isbn, Date dateE) {
        this.titre = titre;
        this.isbn = isbn;
        this.dateE = dateE;
        this.emprunts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDateE() {
        return dateE;
    }

    public void setDateE(Date dateE) {
        this.dateE = dateE;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
