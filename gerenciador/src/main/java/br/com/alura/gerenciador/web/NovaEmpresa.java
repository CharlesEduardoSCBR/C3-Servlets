package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome;
		Empresa empresa;
		PrintWriter writer;
		
		nome = req.getParameter("nome");
		empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		writer = resp.getWriter();
		writer.println("<html><body>Empresa " + nome + " adicionada!</body></html>");
	}
}
