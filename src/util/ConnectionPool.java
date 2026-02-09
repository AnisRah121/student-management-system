package StudentService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final String URL =
        "jdbc:postgresql://localhost:5432/school?user=postgres&password=123";

    private static List<Connection> pool = new ArrayList<>();

    static {
        try {
            Class.forName("org.postgresql.Driver");

            
            for (int i = 0; i < 5; i++) {
                Connection con = DriverManager.getConnection(URL);
                pool.add(con);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static Connection getConnection() {
        if (pool.isEmpty()) {
            throw new RuntimeException("No connection available in pool");
        }
        return pool.remove(0);
    }

    
    public static void receiveConnection(Connection con) {
        if (con != null) {
            pool.add(con);
        }
    }
}
