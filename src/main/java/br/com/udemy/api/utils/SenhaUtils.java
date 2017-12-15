package br.com.udemy.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
	
	/**
	 * Gera um hash utilizando o BCrypt. 
	 * @param senha
	 * @return String
	 */
	public static String geraBCrypt(String senha) {
		if(senha == null) {
			return senha;
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(senha);
	}
	
	/**
	 * Verifica se a senha é válida
	 * @param senha
	 * @param senhaEncaded
	 * @return boolean
	 */
	public static boolean isValid (String senha, String senhaEncaded) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senha, senhaEncaded);
	}

}
