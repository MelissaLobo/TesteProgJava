import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import validadores.EmailValidador;
import validadores.EmailValidadorImpl;

public class ValidadorEmailTeste {

	private EmailValidador emailValidador = new EmailValidadorImpl();

	@Test
	public void testeValidador() {

		assertFalse(emailValidador.validador(""));
		assertFalse(emailValidador.validador(null));
		assertTrue(emailValidador.validador("teste@teste.com"));
		assertTrue(emailValidador.validador("jose.alcindo@dominio.com"));
		assertTrue(emailValidador.validador("jose.alcindo3@ab.c2.ef.gh.ij"));
		assertFalse(emailValidador.validador("josé@dominio.com"));

	}
}
