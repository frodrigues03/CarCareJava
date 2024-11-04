package Service;

import java.util.Optional;

import Model.Usuario;

public abstract class UsuarioService {
	abstract Optional<Usuario> login(String email, String senha);
    abstract void registrarUsuario(Usuario usuario);
    void adicionarVeiculo(int usuarioId, VeiculoService VeiculoService) {
	}
    void deletarVeiculo(int usuarioId, int carroId) {
	}
    void enviarNotificacao(String mensagem, int usuarioId) {
	}
}
