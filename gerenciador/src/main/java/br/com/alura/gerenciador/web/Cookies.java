package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	private final Cookie[] cookieUsuario;

	public Cookies(Cookie[] cookieUser) {
		this.cookieUsuario = cookieUser;
	}

	public Cookie getUsuarioLogado() {

		if (cookieUsuario == null) {
			return null;
		}

		for (Cookie cookie : cookieUsuario) {
			if (cookie.getName().equals("usuario.logado")) {
				if (cookie.getName().equals("usuario.logado")) {
					return cookie;
				}
			}
		}
		return null;
	}

	public String getValue() {
		return this.cookieUsuario[0].getValue();
	}
}
