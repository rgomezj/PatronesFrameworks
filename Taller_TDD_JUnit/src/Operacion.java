public class Operacion {

	public int sumar(int... numeros) {
		int resultado = 0;
		for (int i : numeros) {
			resultado += i;
		}
		return resultado;
	}

	public double sumar(double... numeros) {
		double resultado = 0;
		for (double i : numeros) {
			resultado += i;
		}
		return resultado;
	}

	public int sumarCapaPresentacion(String... numeros) throws Exception {
		int resultado = 0;

		if (numeros.length == 0) {
			throw new Exception("Array vacio");
		}

		int numValidos = 0;
		for (String i : numeros) {
			if (!i.isEmpty()) {
				Integer.parseInt(i);
				numValidos++;
			}
		}

		if (numValidos > 2) {
			for (String i : numeros) {
				resultado += Double.valueOf(i);
			}
		} else {
			throw new NumerosMinimosException("NUm minimos");
		}

		return resultado;
	}

	public int restarDosNumeros(int i, int j) {
		return i - j;
	}

}
