package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.management.InstanceNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "fazTudo")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeDaClasse;
		String pagina;
		String tarefa;
		Class<?> type;
		RequestDispatcher disp;

		tarefa = req.getParameter("tarefa");

		if (tarefa == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}

		try {
			nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
			type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) type.newInstance();
			pagina = instancia.executa(req, resp);
			disp = req.getRequestDispatcher(pagina);
			disp.forward(req, resp);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException();
		}
	}

}
