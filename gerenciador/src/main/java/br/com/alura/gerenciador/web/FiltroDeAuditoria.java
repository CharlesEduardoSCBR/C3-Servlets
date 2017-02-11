package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Cookies cookie = new Cookies(req.getCookies());
		String usuario = "<deslogado>";

		if (cookie.getUsuarioLogado() != null){
			Cookie c = new Cookies(req.getCookies()).getUsuarioLogado();
			usuario = cookie.getValue();
			c.setMaxAge(600);
			
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.addCookie(c);
		}

		System.out.println("Usuario acessando a URI " + req.getRequestURI());
		chain.doFilter(request, response);
	}
}
