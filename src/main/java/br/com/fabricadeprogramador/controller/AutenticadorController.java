package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/autenticador")
public class AutenticadorController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuConsulta = new Usuario();
		usuConsulta.setLogin(login);
		usuConsulta.setSenha(senha);
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuarioAutenticado = dao.autenticar(usuConsulta);
		
		if(usuarioAutenticado != null) {
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuAutenticado", usuarioAutenticado);
			
			sessao.setMaxInactiveInterval(60*5);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
			dispatcher.forward(req, resp);
		}else {
			resp.getWriter().print("<script>window.alert('Não encontrado'); location.href='login.html';</script>");
		}
	}
}
