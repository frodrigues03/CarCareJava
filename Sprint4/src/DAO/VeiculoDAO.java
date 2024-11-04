package DAO;

import java.util.Optional;

public class VeiculoDAO {
	private int id;
    private String modelo;
    private String placa;
    private int usuarioId;  

    public VeiculoDAO(int id, String modelo, String placa, int usuarioId) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

	public void adicionar(VeiculoDAO veiculoDAO) {
		// TODO Auto-generated method stub
		
	}

	public Optional<VeiculoDAO> buscar(int carroId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletar(int veiculoId) {
		// TODO Auto-generated method stub
		
	}
}
