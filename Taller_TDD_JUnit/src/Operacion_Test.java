import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class Operacion_Test {

	private Operacion operacion;

	@Before
	public void setUp() throws Exception {
		operacion = new Operacion();
	}

	@Test
	public void sumar2Mas2Igual4() {
		int resultado = operacion.sumar(2, 2);
		assertEquals(resultado, 4);
	}

	@Test
	public void sumarMenos2Mas2Igual0() {
		int resultado = operacion.sumar(-2, 2);
		assertEquals(resultado, 0);
	}

	@Test
	public void sumarMenos2Menos5Igual7() {
		int resultado = operacion.sumar(-2, -5);
		assertEquals(resultado, -7);
	}

	@Test
	public void sumarMasDeDosNumeros() {
		int resultado = operacion.sumar(-2, -5, 8, 10);
		assertEquals(resultado, 11);
	}

	@Test
	public void sumarDecimales() {
		double resultado = operacion.sumar(-2.5d, -2.5, 5.5, 4.5);
		assertEquals(Double.valueOf(resultado), Double.valueOf(5));
	}

	@Test(expected = NumberFormatException.class)
	public void sumarCapaPresentacionNumerosNoValidos() throws Exception {
		int resultado = operacion.sumarCapaPresentacion("4", "5", "6", "roger");
	}

	@Test(expected = NumerosMinimosException.class)
	public void sumarCapaPresentacionExceptioNumMinimos() throws Exception {
		int resultado = operacion.sumarCapaPresentacion("4");
	}
	
	@Test(expected = NumerosMinimosException.class)
	public void sumarCapaPresentacionExceptioNumMinimosVacios() throws Exception {
		int resultado = operacion.sumarCapaPresentacion("4", "");
	}
	
	@Test(expected = Exception.class)
	public void sumarCapaPresentacionExceptioVacioNumMinimos() throws Exception {
		int resultado = operacion.sumarCapaPresentacion("");
	}

	@Test
	public void validarSumaNula() {
		int resultado = operacion.sumar();
		assertEquals(resultado, 0);
	}

	@Test
	public void RestarEnterosPositivos() {
		int resultado = operacion.restarDosNumeros(3, 2);
		assertEquals(1, resultado);
	}
	
	@Test
	public void restarConResutadoNegativo() {
		int resultado = operacion.restarDosNumeros(2, 3);
		assertEquals(-1, resultado);
	}
	
	@Test
	public void restarEnterosNegativos() {
		int resultado = operacion.restarDosNumeros(-3, -2);
		assertEquals(-1, resultado);
	}
	
	@Test
	public void restarEnterosNegativosPositivos() {
		int resultado = operacion.restarDosNumeros(-3, 2);
		assertEquals(-5, resultado);
	}
	
	public void restarEnterosResultadoPositivo() {
		int resultado = operacion.restarDosNumeros(3, -2);
		assertEquals(5, resultado);
	}
	
	@Test
	public void multiplicar5x8igual40(){
		Calculadora calculadora = new Calculadora();
		
		assertEquals(new Double(40), new Double(calculadora.multiplicar(5,8)));
	}
	
	@Test
	public void multiplicar100x0igual0(){
		Calculadora calculadora = new Calculadora();
		assertEquals(new Double(0), new Double(calculadora.multiplicar(100,0)));
	}
}
