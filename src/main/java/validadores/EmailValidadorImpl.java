package validadores;

/*
 * Validacao de Email
 *  @author Melissa Lobo mellobomel@gmail.com
 */

public class EmailValidadorImpl implements EmailValidador {

	public boolean validador(String email) {

		// Dividindo email em duas partes
		String[] partesArrayString = email.split("@");
		String parteLocal = partesArrayString[0];
		String parteDominio = partesArrayString[1];

		if (email == null || email.isEmpty() || partesArrayString.length > 2) {
			return false;
		}

		// Verificação da parte local

		// Deve ter até 64 caracteres de comprimento e nao menos do que 4
		if (parteLocal.length() > 64 || parteLocal.length() < 4
				&& parteLocal.matches("//s")) {
			return false;
		}

		// Caractere '.' é valido, mas nao pode iniciar e terminar a palavra ou
		// ocorrer em sequencia
		if (parteLocal.startsWith(".") || parteLocal.endsWith("."))
			return false;
		String[] ponto = parteLocal.split("\\.");
		for (String s : ponto) {
			if (s.length() == 0)
				return false;
		}
		// Os caracteres validos sao apenas alfanumericos, minusculos ou nao
		if (parteLocal.matches("//w")) {
			return true;
		}

		// **BONUS 1 - 'local' com caracteres especiais: ! # $ % & * + =
		boolean cond = parteLocal.matches("[!#$%&*]+");
		if (!cond)
			return false;

		return true;
	}
}
