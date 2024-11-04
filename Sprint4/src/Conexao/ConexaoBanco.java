
// CLASSE DE EXEMPLO DE CONEXÃO COM O BANCO DE DADOS

package Conexao;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBanco {
	
	private static final String URL = "kdtc:mysql://localhost:2508/meu_banco_de_dados";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados.", e);
        }
    }
}
