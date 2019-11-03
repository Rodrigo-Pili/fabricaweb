package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usucontroller")
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
		System.out.println("Construtor..");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Init...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		if(acao.equals("excluir")) {
			System.out.println("chamou doGet!" + req);
			
			String id = req.getParameter("id");
			
			Usuario usu = new Usuario();
			if(id != null) {
				usu.setId(Integer.parseInt(id));
			}
			
			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir((usu));
			
			resp.sendRedirect("usucontroller?acao=lis");
		}else if(acao.equals("lis")){
			
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> lista = dao.buscaTodosUsuarios();

			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listausu.jsp");
			dispatcher.forward(req, resp);
		}else  if(acao.equals("alt")) {
			String id = req.getParameter("id");
			
			Usuario usu = new UsuarioDAO().buscaPorId(Integer.parseInt(id));
			req.setAttribute("usu", usu);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);
		}else if(acao.equals("cad")) {
			Usuario usu = new Usuario();
			usu.setId(0);
			usu.setNome("");
			usu.setLogin("");
			usu.setSenha("");
			req.setAttribute("usu", usu);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("chamou doPost!");

		String id = null;
		
		if(!req.getParameter("id").equals("")) {
			id = req.getParameter("id");
		}
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario usu = new Usuario();
		if(id != null) {
			usu.setId(Integer.parseInt(id));
		}
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usu);

		resp.getWriter().print("<b>sucesso<b>");
	}

}



















