package ma.enset.examen.dao;

import ma.enset.examen.dao.entities.Emprunt;
import ma.enset.examen.dao.entities.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpruntDaoImp implements EmpruntDao{
    @Override
    public List<Emprunt> findAll() throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Emprunt");
        ResultSet rs = stm.executeQuery();
        AdherentDaoImp adherentDaoImp = new AdherentDaoImp();
        LivreDaoImp livreDaoImp = new LivreDaoImp();
        List<Emprunt> emprunts = new ArrayList<>();
        while (rs.next()){
            Emprunt e = new Emprunt();
            e.setId(rs.getInt("ID"));
            e.setDateRe(rs.getDate("DATE_R"));
            e.setDateEmp(rs.getDate("DATE_EM"));
            e.setAdherent(adherentDaoImp.findByID(rs.getInt("ID_ADHERENT")));
            e.setLivre(livreDaoImp.findByID(rs.getInt("ID_LIVRE")));
            emprunts.add(e);
        }
        return emprunts;
    }

    @Override
    public Emprunt findByID(int id) throws SQLException {
        return null;
    }

    @Override
    public Emprunt save(Emprunt emprunt) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("insert into Emprunt(DATE_R,DATE_EM,ID_ADHERENT,ID_LIVRE) " +
                "values (?,?,?,?)");

        stm.setDate(1,emprunt.getDateRe());
        stm.setDate(2,emprunt.getDateEmp());
        stm.setInt(3,emprunt.getAdherent().getId());
        stm.setInt(3,emprunt.getLivre().getId());
        stm.executeUpdate();
        return emprunt;
    }

    @Override
    public Emprunt delete(Emprunt emprunt) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("delete from Emprunt where ID=?");
        stm.setInt(1,emprunt.getId());
        stm.executeUpdate();
        return emprunt;
    }

    @Override
    public Emprunt update(Emprunt emprunt) throws SQLException {
        return null;
    }
}
