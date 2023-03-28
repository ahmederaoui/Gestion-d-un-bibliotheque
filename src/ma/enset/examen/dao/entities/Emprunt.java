package ma.enset.examen.dao.entities;

import java.io.Serializable;
import java.sql.Date;

public class Emprunt implements Serializable {
    private int id;
    private Date dateEmp;
    private Date dateRe;
    private Livre livre;
    private Adherent adherent;

    public Emprunt() {
    }

    public Emprunt( Date dateEmp, Date dateRe, Livre livre, Adherent adherent) {
        this.dateEmp = dateEmp;
        this.dateRe = dateRe;
        this.livre = livre;
        this.adherent = adherent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEmp() {
        return dateEmp;
    }

    public void setDateEmp(Date dateEmp) {
        this.dateEmp = dateEmp;
    }

    public Date getDateRe() {
        return dateRe;
    }

    public void setDateRe(Date dateRe) {
        this.dateRe = dateRe;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
}
