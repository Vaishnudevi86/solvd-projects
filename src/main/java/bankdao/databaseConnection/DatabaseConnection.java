package bankdao.databaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DatabaseConnection {
        private static final String JDBC_URL="jdbc:mysql://localhost:3306/bank_schema";
        private static final String USERNAME="root";
        private static final String PASSWORD="vaish@mysql";
        private DatabaseConnection(){
        }
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
        }
    }