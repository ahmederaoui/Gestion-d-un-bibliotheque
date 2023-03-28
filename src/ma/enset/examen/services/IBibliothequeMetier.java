package ma.enset.examen.services;

import ma.enset.examen.dao.AdherentDao;
import ma.enset.examen.dao.entities.Adherent;
import ma.enset.examen.dao.entities.Emprunt;
import ma.enset.examen.dao.entities.Livre;

import java.util.List;

public interface IBibliothequeMetier {
    List<Adherent> getAllAdherent();
    List<Adherent> getAdherentByMc(String mc);
    void addAdherent(Adherent a);
    void deleteAdherent(Adherent a);
    List<Emprunt> getAdherentEmprunts(int id);
    void addLivre(Livre l);
    List<Livre> getAllLivre();
    void deleteLivre(Livre l);
    void updateLivre(Livre l);
    void addEmprunt(Emprunt e);
    List<Emprunt> getAllEmprunt();
    void deleteEmprunt(Emprunt e);
}
