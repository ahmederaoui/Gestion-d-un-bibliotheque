package ma.enset.examen.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

public class SignletonConnexionDB {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
