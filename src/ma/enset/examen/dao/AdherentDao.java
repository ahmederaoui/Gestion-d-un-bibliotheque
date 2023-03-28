package ma.enset.examen.dao;

import ma.enset.examen.dao.entities.Adherent;
import ma.enset.examen.dao.entities.Emprunt;

import java.sql.SQLException;
import java.util.List;

public interface AdherentDao extends Dao<Adherent> {
    List<Adherent> findByMc(String mc) throws SQLException;
    List<Emprunt>  empruntsByAdherent(int idAdherent) throws SQLException;
}
