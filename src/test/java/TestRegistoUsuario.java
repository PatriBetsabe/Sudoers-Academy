package test.java;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import main.java.RegistroUsuario;

import org.junit.Test;

public class TestRegistoUsuario{
	@Test
	public void testValidaEmailOk() {
		assertTrue(RegistroUsuario.validaEmail("hola@hola.com"));
	}
	
	@Test
	public void testValidaEmailNoOk() {
		assertFalse(RegistroUsuario.validaEmail("hola@.com"));
		assertFalse(RegistroUsuario.validaEmail(""));
	}
	
	@Test
	public void testValidaPasswordOk() {
		assertTrue(RegistroUsuario.validaPassword("gr3at@3wdsG"));
	}
	
	@Test
	public void testValidaPasswordNoOk() {
		assertFalse(RegistroUsuario.validaPassword("123456789"));
		assertFalse(RegistroUsuario.validaPassword(""));
	}
	
	@Test
	public void testValidaNicknameOk() {
		assertTrue(RegistroUsuario.validaNickName("usuario"));
	}
	
	@Test
	public void testValidaNicknameNoOk() {
		assertFalse(RegistroUsuario.validaPassword("Usuario"));
		assertFalse(RegistroUsuario.validaPassword(""));
	}

	 
}
