import java.sql.*;
import java.util.*;

public class FuncionarioDAO {

    public FuncionarioDAO() {
        try (Connection conn = ConexaoBD.getConnection()) {
            String sql = "CREATE TABLE IF NOT EXISTS funcionarios ("
                       + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                       + "nome TEXT NOT NULL,"
                       + "idade INTEGER,"
                       + "salario REAL,"
                       + "tipo TEXT,"
                       + "bonus REAL"
                       + ");";
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserir(Funcionario f) {
        try (Connection conn = ConexaoBD.getConnection()) {

            String sql = "INSERT INTO funcionarios (nome, idade, salario, tipo, bonus) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, f.getNome());
            ps.setInt(2, f.getIdade());
            ps.setDouble(3, f.getSalarioBase());

            if (f instanceof Gerente g) {
                ps.setString(4, "GERENTE");
                ps.setDouble(5, g.calcularSalario() - f.getSalarioBase());
            } else {
                ps.setString(4, "FUNCIONARIO");
                ps.setDouble(5, 0);
            }

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<>();

        try (Connection conn = ConexaoBD.getConnection()) {
            String sql = "SELECT * FROM funcionarios";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("tipo").equals("GERENTE")) {
                    lista.add(new Gerente(
                        rs.getInt("id"),
        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getDouble("salario"),
                        rs.getDouble("bonus")
                    ));
                } else {
                    lista.add(new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getDouble("salario")
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }

        return lista;
    }
}