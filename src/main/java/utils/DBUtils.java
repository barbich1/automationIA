package utils;

import java.sql.*;

public class DBUtils {
    private static final String URL = "jdbc:sybase:Tds:localhost:5000/DB";
    private static final String USER = "usuario";
    private static final String PASS = "contraseña";

    public static boolean usuarioTieneEmailEnrolado(String dni) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT COUNT(*) FROM usuarios WHERE dni = ? AND email IS NOT NULL")) {
            stmt.setString(1, dni);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }
}
