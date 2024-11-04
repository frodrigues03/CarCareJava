package DAO;

import java.sql.*;
import java.util.Optional;

import Model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	private Connection conexao;

    public UsuarioDAOImpl(Connection conexao) {
        this.conexao = conexao;
    }
    public Optional<Usuario> login(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                    );
                    return Optional.of(usuario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar login: " + e.getMessage());
        }
        return Optional.empty();
    }
    public void adicionarCarro(VeiculoDAO VeiculoDAO) {
        String sql = "INSERT INTO carros (modelo, placa, usuario_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, VeiculoDAO.getModelo());
            stmt.setString(2, VeiculoDAO.getPlaca());
            stmt.setInt(3, VeiculoDAO.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar carro: " + e.getMessage());
        }
    }
    public void deletarCarro(int carroId) {
        String sql = "DELETE FROM carros WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, carroId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar carro: " + e.getMessage());
        }
    }
}
