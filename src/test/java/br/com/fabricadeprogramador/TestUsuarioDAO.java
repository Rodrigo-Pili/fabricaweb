package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {

		//cadastrar();
		//alterar();
		excluir();
	}

	private static void cadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Joazao");
		usu.setLogin("jzao");
		usu.setSenha("jzao");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadastrado com sucesso!");
	}
	
	private static void alterar() {
		Usuario usu = new Usuario();
		usu.setId(4);
		usu.setNome("maria eduarda");
		usu.setLogin("maria");
		usu.setSenha("maria");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		
		System.out.println("Alterado com sucesso!");
	}
	
	private static void excluir() {
		Usuario usu = new Usuario();
		usu.setId(7);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Apagado com sucesso!");
	}
	
	

}
