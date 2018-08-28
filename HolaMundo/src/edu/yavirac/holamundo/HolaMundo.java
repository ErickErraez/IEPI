package edu.yavirac.holamundo;

public class HolaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundo IDE :)");

		// Enteros
		byte edad = 127;
		short year = -32768;
		int id_user = 1001;
		long id_twitter = 12345678923456789L;

		// Punto Flotante
		float diametro = 34.25F;
		double precio = 12345.2345678923456723456234;

		// Texto
		char genero = 'M';

		// Logico
		boolean isVisible = true;
		boolean funciona = false;

		int variable = 2;
		int _variable = 3;
		int $variable = 4;
		int variable1 = 5;

		// Constantes
		int VALOR = 0;
		int VALOR_MAXIMO = 1;

		// Lower Camel Case
		int minValor = 4;

		byte b = 6;
		short s = b;

		b = (byte) s;

		int i = 1;
		double d = 2.8;
		i = (int) d;

		int codigo = 97;
		char codigoASCII = (char) codigo;

		short numero = 300;
		byte numeroByte = (byte) numero;

		// Arrays
		// Declaracion de Array
		int[] arregloInt = new int[3]; // Solo guarda datos de tipo entero
		double arregloDouble[]; // Forma 2 de Declarar

		int[][] array2D = new int[2][3];// El numero 2 son las filas y el numero 3 define las columnas
		int[][][] array3D = new int[3][3][2];// El numero 3 define las filas el otro 3 define las columnas y el 2 define
												// la altura

		// Otra forma de Declarar Arreglos
		char[][] names = { { 'M', 'T' }, { 'M', 'T' } };

		// ARREGLOS DE MAS DE 3 YA NO ES UNA BUENA PRACTICA

		// Navegar entre Arrays
		char[] name = new char[5];
		name[0] = 'H';
		name[1] = 'O';
		name[2] = 'L';
		name[3] = 'A';

		System.out.println(name[0]);
		System.out.println(name[1]);
		System.out.println(name[2]);
		System.out.println(name[3]);

		char[][][][] monkey = new char[2][3][2][2];
		monkey[1][0][0][1] = 'M';
		System.out.println(monkey[1][0][0][1]);

		// Operadores Aritmeticos
		int a = 1;
		int aa = a + a;
		System.out.println("El valor de aa es: " + aa);

		double x = 2.56;
		int y = 9;

		float w = (float) x + y;
		System.out.println(w);

		System.out.println(w * 2);

		double k = 4 / 0.00002;
		System.out.println(k);
		System.out.println(7 % 2);

		int f = 2;
		int g = 3;
		// f = f+g;
		f += g; // Esto funciona con cualquier operador aritmetico
		System.out.println(f);

		// Incremento y Decremento
		int l = 3;
		l++;
		++l;
		System.out.println(l);

		// ++l
		// 1. Incrementar el valor es decir l+1
		// 2. Asignar el valor a l
		// System.out.println(++l);

		// l++
		// 1. Asignar el valor a l ed decur l=l
		// 2. Incrementar el valor l+1
		// System.out.println(l++);
		// System.out.println(l);//4

		// Operadores de Equidad
		int q = 8;
		int p = 5;
		System.out.println(q != p);

		// Operadores relacionales
		System.out.println("q > p ->" + (q > p));
		System.out.println("q < p ->" + (q < p));

		System.out.println("q >= p ->" + (q >= p));
		System.out.println("q <= p ->" + (q <= p));

		// Operadores lógicos
		boolean n = false;
		boolean m = true;

		System.out.println("n && m -> " + (n && m));
		System.out.println("n || m -> " + (n || m));
		System.out.println("!n -> " + (!n));
		System.out.println("!m -> " + (!m));

		// IF Y ELE
		if (q >= p && q == 10) {
			System.out.println("Entro al If");
		} else if (p == 5) {
			System.out.println("Entro al Else");
		}

		// Ejemplo Switch en Java
		int mes = 8;

		switch (mes) {
		case 1:
			System.out.println("Enero");
			break;
		case 2:
			System.out.println("Febrero");
			break;
		case 3:
			System.out.println("Marzo");
			break;
		case 4:
			System.out.println("Abril");
			break;
		case 5:
			System.out.println("Mayo");
			break;
		case 6:
			System.out.println("Junio");
			break;
		case 7:
			System.out.println("Julio");
			break;
		case 8:
			System.out.println("Agosto");
			break;
		case 9:
			System.out.println("Septiembre");
			break;
		case 10:
			System.out.println("Octubre");
			break;
		case 11:
			System.out.println("Noviembre");
			break;
		case 12:
			System.out.println("Diciembre");
			break;

		default:
			System.out.println("No Existe el mes");
			break;
		}

		// Bucle While

		int e = 1;

		while (e <= 5) {
			System.out.println("Es igual a 1");
			e++;
		}
		System.out.println();

		// Bucle For
		int[] numeros = new int[5];

		for (int c = 0; c < 5; c++) {
			numeros[c] = c;
			System.out.println("numeros[" + c + "]: " + numeros[c]);
		}
		System.out.println();
		
		//Foreach
		for (int j : numeros) {
		System.out.println(j);	
		}
		
		System.out.println("Continuacion del Flujo");

		
		
	}

}
