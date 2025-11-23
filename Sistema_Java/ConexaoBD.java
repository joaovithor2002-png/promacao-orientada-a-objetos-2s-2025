import java.sql.*;

public class ConexaoBD {

    private static final String URL = "jdbc:sqlite:funcionarios.db";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}