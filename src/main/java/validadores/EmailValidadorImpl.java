package validadores;

/*
 * Validacao de Email
 *  @author Melissa Lobo mellobomel@gmail.com
 */

public class EmailValidadorImpl implements EmailValidador {

	public boolean validador(String email) {

		//Dividindo email em duas partes
		String[] partesArrayString = email.split("@");
		String parteLocal = partesArrayString[0];
		String parteDominio = partesArrayString[1];

		if (email == null || email.isEmpty() || partesArrayString.length > 2) {
			return false;
		}

		// Verificação da parte local

		// Deve ter até 64 caracteres de comprimento e nao menos do que 4
		if (parteLocal.length() > 64 || parteLocal.length() < 4 && parteLocal.matches("//s")) {
			return false;
		}

		// Caractere '.' é valido, mas nao pode iniciar e terminar a palavra ou
		// ocorrer em sequencia
		if (parteLocal.startsWith(".") || parteLocal.endsWith(".")) {
			return false;
		}

		String[] ponto = parteLocal.split("\\.");
		for (String s : ponto) {
			if (s.length() == 0)
				return false;
		}

		// Os caracteres validos sao apenas alfanumericos, minusculos ou nao
		if (parteLocal.matches("//w")) {
			return true;
		}

		// BONUS 1 - 'local' com caracteres especiais: ! # $ % & * + =
		boolean cond = parteLocal.matches("[!#$%&*]+");
		if (!cond)
			return false;

		// BONUS 2 - 'local' pode ter qualquer conteuÌ�do desde que inicie e
		// termine entre aspas duplas
		if (parteLocal.startsWith("\"") && parteLocal.endsWith("\"")) {

			return true;
		}

		// Verificacao da parte dominio

		// Dominio nao pode exceder 255 caraceteres.
		if (parteDominio.length() > 255 || parteDominio.length() < 4) {
			return false;
		}
		
		//Dividindo em etiquetas
		String[] etiquetas = parteDominio.split("\\.");

		// Etiquetas devem ter ao menos 2 caraceteres e no maximo 63.
		for (String e : etiquetas) {
			if (e.length() < 2 || e.length() > 63)
				return false;
		}

		// BONUS 3 - 'dominio' deve ser composto por entre 2 e 6 etiquetas, e a
		// uÌltima contendo apenas 2 ou 3 caracteres.
		if (etiquetas.length < 2 || etiquetas.length > 6) {
			return false;
		}
		if (etiquetas[etiquetas.length - 1].length() < 2
				|| etiquetas[etiquetas.length - 1].length() > 3) {
			return false;
		}

		// BONUS 4 - Etiquetas podem ter hifens, embora nunca possam iniciar ou
		// terminar uma etiqueta e nem ocorrer consecutivamente
		for (String e : etiquetas) {
			if (e.startsWith("-") || e.endsWith("-"))
				return false;

			String[] hifen = e.split("-");
			for (String s : hifen) {
				if (s.length() == 0)
					return false;
			}
		}
		return true;
	}

}
