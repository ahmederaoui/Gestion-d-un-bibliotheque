package ma.enset.examen.services;

import ma.enset.examen.dao.entities.Adherent;
import ma.enset.examen.dao.entities.Emprunt;
import ma.enset.examen.dao.entities.Livre;

import java.sql.Date;
import java.util.List;

public class appConsole {
    public static void main(String[] args) {
        Date date1 = new Date(2023-1900,10,12);
        Date date2 = new Date(2023-1900,11,22);
        Date date3 = new Date(2022-1900,12,12);
        Date date4 = new Date(2023-1900,10,14);
        Livre livre1 = new Livre("Glsid","isbn",date1);
        Adherent adherent = new Adherent("el hanafi","yassine","gm12433214","068263542","yasiine@gmail.com",date2);
        IBibliothequeMetier iBibliothequeMetier = new IBibliothequeMetierImp();
        iBibliothequeMetier.addAdherent(adherent);
        iBibliothequeMetier.addLivre(livre1);
        List<Adherent> adherents = iBibliothequeMetier.getAllAdherent();

        List<Livre> livres = iBibliothequeMetier.getAllLivre();
        System.out.println("liste Adherent");
        for (Adherent a:adherents
             ) {
            System.out.println(a.getNom()+" "+a.getPrenom());
        }
        List<Adherent> adherents1= iBibliothequeMetier.getAdherentByMc("yassine");
        System.out.println("liste Adherent par mot cle yassine");
        Adherent adherent1 = new Adherent();
        for (Adherent a:adherents1
        ) {
            System.out.println(a.getNom()+" "+a.getPrenom());
            adherent1 = a;
            iBibliothequeMetier.deleteAdherent(a);
        }
        System.out.println("liste livre avant la supression");
        for (Livre l:livres
             ) {
            System.out.println(l.getTitre());
            iBibliothequeMetier.deleteLivre(l);
        }
        System.out.println("liste livre apres la supression");
        System.out.println("ajoute livre 1 pour voir la suupression");
        iBibliothequeMetier.addLivre(livre1);
        Livre livre2 = new Livre();
        for (Livre l:livres
        ) {
            System.out.println(l.getTitre());
            livre2 = l;
        }
        iBibliothequeMetier.addAdherent(adherent);
        Emprunt emprunt= new Emprunt(date3,date4,livre2,adherent1);

    }
}
