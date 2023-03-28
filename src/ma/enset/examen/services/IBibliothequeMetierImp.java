package ma.enset.examen.services;

import ma.enset.examen.dao.AdherentDaoImp;
import ma.enset.examen.dao.EmpruntDaoImp;
import ma.enset.examen.dao.LivreDaoImp;
import ma.enset.examen.dao.entities.Adherent;
import ma.enset.examen.dao.entities.Emprunt;
import ma.enset.examen.dao.entities.Livre;

import java.util.List;

public class IBibliothequeMetierImp implements IBibliothequeMetier{
    private AdherentDaoImp adherentDaoImp = new AdherentDaoImp();
    private LivreDaoImp livreDaoImp = new LivreDaoImp();
    private EmpruntDaoImp empruntDaoImp = new EmpruntDaoImp();

    public IBibliothequeMetierImp() {
    }

    @Override
    public List<Adherent> getAllAdherent() {
        try {
            return adherentDaoImp.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Adherent> getAdherentByMc(String mc) {
        try {
            return adherentDaoImp.findByMc(mc);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public void addAdherent(Adherent a) {
        try {
            adherentDaoImp.save(a);
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @Override
    public void deleteAdherent(Adherent a) {
        try {
            adherentDaoImp.delete(a);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public List<Emprunt> getAdherentEmprunts(int id) {
        try {
            return adherentDaoImp.empruntsByAdherent(id);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public void addLivre(Livre l) {
        try {
            livreDaoImp.save(l);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public List<Livre> getAllLivre() {
        try {
            return livreDaoImp.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteLivre(Livre livre) {
        try {
            livreDaoImp.delete(livre);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void updateLivre(Livre l) {
        try {
            livreDaoImp.update(l);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void addEmprunt(Emprunt em) {
        try {
            empruntDaoImp.save(em);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public List<Emprunt> getAllEmprunt() {
        try {
            return  empruntDaoImp.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteEmprunt(Emprunt em) {
        try {
            empruntDaoImp.delete(em);
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
