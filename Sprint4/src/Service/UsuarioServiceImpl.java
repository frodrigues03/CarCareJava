package Service;

import java.util.Optional;

import DAO.UsuarioDAO;
import Model.Usuario;

public class UsuarioServiceImpl {
	 private UsuarioDAO usuarioDAO;
	    private DAO.VeiculoDAO VeiculoDAO;

	    public UsuarioServiceImpl(UsuarioDAO usuarioDAO, DAO.VeiculoDAO VeiculoDAO) {
	        this.usuarioDAO = usuarioDAO;
	        this.VeiculoDAO = VeiculoDAO;
	    }

	    public Optional<Usuario> login(String email, String senha) {
	        Optional<Usuario> usuario = usuarioDAO.login(email, senha);
	        if (usuario.isPresent()) {
	            System.out.println("Login realizado com sucesso para o usuário: " + email);
	        } else {
	            System.out.println("Falha no login: e-mail ou senha incorretos.");
	        }
	        return usuario;
	    }

	    public void registrarUsuario(Usuario usuario) {
	        usuarioDAO.registrar(usuario);
	        System.out.println("Usuário registrado com sucesso: " + usuario.getNome());
	    }

	    public void adicionarVeiculo(int usuarioId, DAO.VeiculoDAO Veiculo) {
	        Optional<Usuario> usuario = usuarioDAO.buscar(usuarioId);
	        if (usuario.isPresent()) {
	            VeiculoDAO.setUsuarioId(usuarioId);
	            VeiculoDAO.adicionar(VeiculoDAO);
	            System.out.println("Veículo adicionado para o usuário " + usuario.get().getNome());
	        } else {
	            System.out.println("Usuário não encontrado. Não foi possível adicionar o veículo.");
	        }
	    }

	    public void deletarVeiculo(int usuarioId, int VeiculoId) {
	        Optional<DAO.VeiculoDAO> carro = VeiculoDAO.buscar(VeiculoId);
	        if (carro.isPresent() && carro.get().getUsuarioId() == usuarioId) {
	            VeiculoDAO.deletar(VeiculoId);
	            System.out.println("Veículo deletado com sucesso para o usuário ID: " + usuarioId);
	        } else {
	            System.out.println("Veículo não encontrado ou não pertence ao usuário.");
	        }
	    }

	}
