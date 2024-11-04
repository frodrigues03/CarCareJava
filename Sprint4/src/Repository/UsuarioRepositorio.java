package Repository;

import org.junit.jupiter.api.Test;	
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.SpringApplication;	
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Optional;


public class UsuarioRepository {
	public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	    Optional<Usuario> findByEmail(String email);
	}

	// CarroRepository.java
	package Repository;

	import com.exemplo.projetoautomotivo.model.Carro;
	import org.springframework.data.jpa.repository.JpaRepository;

	import java.util.List;

	public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
	    List<Veiculo> findByUsuarioId(Integer usuarioId);
	}
