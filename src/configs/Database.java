package configs;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

public class Database {
    private final String DATABASE_URL = "jdbc:sqlite:db\\demo.db";
    
  protected ConnectionSource getConnection() {
        try {
            return new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
  }
}
