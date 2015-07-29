package validadores;

public class EmailValidadorImpl implements EmailValidador {

	public boolean validador(String email) {

		if (email == null || email.isEmpty()) {
			return false;
		}

		String[] partesArrayString = email.split("@");
		String parteLocal = partesArrayString[0];
		String parteDominio = partesArrayString[1];
		partesArrayString[1].split(".");

		if (parteLocal.length() > 64 || parteLocal.length() < 4 && parteLocal.matches("//s")) {
			return false;
		}
		if( parteLocal.matches("//w")) {
			return true;
		}
		
		if(parteDominio.length() > 255 || parteDominio.length() < 4 && parteDominio.matches("//s")) {
			return false;
		}
			return true;
	}

}
