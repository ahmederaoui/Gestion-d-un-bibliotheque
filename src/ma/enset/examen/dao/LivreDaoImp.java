package ma.enset.examen.dao;

import ma.enset.examen.dao.entities.Adherent;
import ma.enset.examen.dao.entities.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreDaoImp implements LivreDao{
    @Override
    public List<Livre> findAll() throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Livre");
        ResultSet rs = stm.executeQuery();
        List<Livre> livres = new ArrayList<>();
        while (rs.next()){
            Livre l = new Livre();
            l.setId(rs.getInt("ID"));
            l.setTitre(rs.getString("TITRE"));
            l.setIsbn(rs.getString("ISBN"));
            l.setDateE(rs.getDate("DATE_E"));
            livres.add(l);
        }
        return livres;
    }

    @Override
    public Livre findByID(int id) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Livre where ID = ?");
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        Livre l = new Livre();
        if (rs.next()){
            l.setId(rs.getInt("ID"));
            l.setTitre(rs.getString("TITRE"));
            l.setIsbn(rs.getString("ISBN"));
            l.setDateE(rs.getDate("DATE_E"));
        }
        return l;
    }

    @Override
    public Livre save(Livre livre) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("insert into Livre(TITRE,ISBN,DATE_E) " +
                "values (?,?,?)");
        stm.setString(1,livre.getTitre());
        stm.setString(2,livre.getIsbn());
        stm.setDate(3,livre.getDateE());
        stm.executeUpdate();
        return livre;
    }

    @Override
    public Livre delete(Livre livre) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("delete from Livre where ID=?");
        stm.setInt(1,livre.getId());
        stm.executeUpdate();
        return livre;
    }

    @Override
    public Livre update(Livre livre) throws SQLException {
        Connection connection = SignletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("update Livre set Titre=? ,ISBN =?,DATE_E=? where ID=?");
        stm.setString(1,livre.getTitre());
        stm.setString(2,livre.getIsbn());
        stm.setDate(3,livre.getDateE());
        stm.setInt(4,livre.getId());
        stm.executeUpdate();
        return livre;
    }
}
