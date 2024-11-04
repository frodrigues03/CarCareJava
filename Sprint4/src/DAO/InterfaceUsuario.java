package DAO;

import java.util.Optional;

import Model.Usuario;

public interface InterfaceUsuario<Carro> {
	Optional<Usuario> login(String email, String senha);
    void adicionarCarro(Carro carro);
    void deletarCarro(int carroId);
}
