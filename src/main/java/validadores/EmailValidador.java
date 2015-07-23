package validadores;

public interface EmailValidador {

	// Boa Pratica para que todos possam usar o metodo validador, implementando
	// a logica da maneira que melhor atender suas necessidades
	public boolean validador(String email);
}
