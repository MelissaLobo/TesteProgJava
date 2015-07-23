package validadores;

public class EmailValidadorImpl implements EmailValidador{

	public boolean validador(String email) {
		
		if(email == null || email.isEmpty()){
			return false;
		}

		String [] partesArrayString = email.split("@");
		String parteLocal = partesArrayString[0];
		String parteDominio = partesArrayString[1];
		
		if(parteLocal.length() > 64 || parteLocal.length() < 4){
			return false;
		}
		//parteLocal.matches("[A-z]");
		System.out.println(parteLocal.matches("[a-z]"));
		
		
		return false;
		
	}

}
