package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {

		//cadastrar();
		//alterar();
		//excluir();
		//salvar();
		//buscaPorId();
		//buscaTodos();
		autenticar();
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
		usu.setId(11);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Apagado com sucesso!");
	}
	
	private static void salvar() {
		Usuario usu = new Usuario();
		//usu.setId(4);
		usu.setNome("Maria de souza");
		usu.setLogin("mar");
		usu.setSenha("123");
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usu);
		
		System.out.println("Salvo com sucesso!");
	}
	
	private static void buscaPorId() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscaPorId(9);
		
		System.out.println(usuario);
	}
	
	private static void buscaTodos() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> todosUsuarios = dao.buscaTodosUsuarios();
		
		for(Usuario u: todosUsuarios) {
			System.out.println(u);
		}
	}
	
	private static void autenticar() {
		Usuario usuario = new Usuario();
		usuario.setLogin("digopili");
		usuario.setSenha("dia130898");
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuarioRetorno = dao.autenticar(usuario);
		
		System.out.println(usuarioRetorno);
	}

}
