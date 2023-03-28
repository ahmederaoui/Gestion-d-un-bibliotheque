package ma.enset.examen.dao;

import ma.enset.examen.dao.entities.Adherent;
import ma.enset.examen.dao.entities.Emprunt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdherentDaoImp implements AdherentDao {
    @Override
    public List<Adherent> findByMc(String mc) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Adherent where NOM like ? or PRENOM like ?");
        stm.setString(1,"%"+mc+"%");
        stm.setString(2,"%"+mc+"%");
        ResultSet rs = stm.executeQuery();
        List<Adherent> adherents = new ArrayList<>();
        while (rs.next()){
            Adherent a = new Adherent();
            a.setId(rs.getInt("ID"));
            a.setNom(rs.getString("NOM"));
            a.setPrenom(rs.getString("PRENOM"));
            a.setTelephone(rs.getString("TELEPHONE"));
            a.setEmail(rs.getString("EMAIL"));
            a.setEmail(rs.getString("CIN"));
            a.setDateN(rs.getDate("DATE_N"));
            adherents.add(a);
        }
        return adherents;
    }

    @Override
    public List<Emprunt> empruntsByAdherent(int idAdherent) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Emprunts where ID_ADHERENT=?");
        stm.setInt(1,idAdherent);
        ResultSet rs = stm.executeQuery();
        List<Emprunt> emprunts = new ArrayList<>();
        while (rs.next()){
            Emprunt e=new Emprunt();
            e.setId(rs.getInt("ID"));
            e.setDateEmp(rs.getDate("DATE_EM"));
            e.setDateRe(rs.getDate("DATE_Re"));
            emprunts.add(e);
        }
        return emprunts;
    }

    @Override
    public List<Adherent> findAll() throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Adherent");
        ResultSet rs = stm.executeQuery();
        List<Adherent> adherents = new ArrayList<>();
        while (rs.next()){
            Adherent a = new Adherent();
            a.setId(rs.getInt("ID"));
            a.setNom(rs.getString("NOM"));
            a.setPrenom(rs.getString("PRENOM"));
            a.setTelephone(rs.getString("TELEPHONE"));
            a.setEmail(rs.getString("EMAIL"));
            a.setCin(rs.getString("CIN"));
            a.setDateN(rs.getDate("DATE_N"));
            adherents.add(a);
        }
        return adherents;
    }

    @Override
    public Adherent findByID(int id) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Adherent where ID = ?");
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        Adherent a = new Adherent();
        if (rs.next()){
            a.setId(rs.getInt("ID"));
            a.setNom(rs.getString("NOM"));
            a.setPrenom(rs.getString("PRENOM"));
            a.setTelephone(rs.getString("TELEPHONE"));
            a.setEmail(rs.getString("EMAIL"));
            a.setCin(rs.getString("CIN"));
            a.setDateN(rs.getDate("DATE_N"));
        }
        return a;
    }

    @Override
    public Adherent save(Adherent adherent) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("insert into Adherent(NOM,PRENOM,TELEPHONE,EMAIL,CIN,DATE_N) " +
                "values (?,?,?,?,?,?)");
        stm.setString(1,adherent.getNom());
        stm.setString(2,adherent.getPrenom());
        stm.setString(3,adherent.getTelephone());
        stm.setString(4,adherent.getEmail());
        stm.setString(5,adherent.getCin());
        stm.setDate(6,adherent.getDateN());
        stm.executeUpdate();
        return adherent;
    }

    @Override
    public Adherent delete(Adherent adherent) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("delete from Adherent where ID=?");
        stm.setInt(1,adherent.getId());
        stm.executeUpdate();
        return adherent;
    }

    @Override
    public Adherent update(Adherent adherent) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("update Adherent set NOM=? ,PRENOM =?,TELE=?,EMAIL=?,CIN=?,DATE_N=? where ID=?");
        stm.setString(1,adherent.getNom());
        stm.setString(2,adherent.getPrenom());
        stm.setString(3,adherent.getTelephone());
        stm.setString(4,adherent.getEmail());
        stm.setString(5,adherent.getCin());
        stm.setDate(4,adherent.getDateN());
        stm.setInt(7,adherent.getId());
        stm.executeUpdate();
        return adherent;
    }
}
