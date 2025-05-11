import java.sql.*;

public class DBConnection {
    public static Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:quiz.db");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
