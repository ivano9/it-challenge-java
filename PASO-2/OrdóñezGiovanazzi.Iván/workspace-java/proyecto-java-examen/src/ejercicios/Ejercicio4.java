package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido,
	static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
	static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

	/**
	 * Para ejecutar el método main se debe hacer boton derecho sobre la clase
	 * "Run As --> Java Application"
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("**** inicializando datos ****");

		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));

		System.out.println("**** inicializacion exitosa ****");

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras
		informacion(lista1, 10);

		// EJERCICIO 4.2: corregir el metodo
		List<Integer> union = unionListas(lista1, lista2);
		System.out.println("union: " + union.toString());

		// EJERCICIO 4.3: implementar
		List<Integer> interseccion = interseccionListas(lista1, lista2);
		System.out.println("interseccion: " + interseccion.toString());

		// EJERCICIO 4.4: implementar
		List<Integer> orden1 = ordenaListaAscendente(lista1);
		System.out.println("orden asc: " + orden1);

		// EJERCICIO 4.5: implementar
		List<Integer> orden2 = ordenaListaDescendente(lista2);
		System.out.println("orden desc: " + orden2);

		// EJERCICIO 4.6: implementar
		boolean b = tienenMismoContenido(lista1, lista2);
		System.out.println("mismo contenido: " + b);

	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		// TODO: explicar salidas de los system out y sugerir alguna mejora a la implementacion

		int pares = 0;
		for (Integer n: lista1) {
			if (n % 2 == 0) {
				pares = pares + 1;
			}
		}

		System.out.println("... " + pares);
		// Muestra la cantidad de numeros pares que se encuentran en la lista1.
		// Verificandolo con el operador módulo, si el resto del cociente entre
		// el elemento y el 2 es igual a 0 es porque es un numero par.

		List<Integer> impares = new ArrayList<Integer>();

		for (Integer n: lista1) {
			if (n % 2 != 0) {
				impares.add(n);
			}
		}
		System.out.println("... " + impares.toString());
		//Imprime por consola una lista convertida a string con los elementos impares de la lista1.


		// Sugerencia de implementación: realizar ambos objetivos con un solo for.
		List<Integer> imparess = new ArrayList<Integer>();
		int paress = 0;

		for (Integer n: lista1)
			if (n % 2 == 0)
				paress++;
			else imparess.add(n);

		System.out.println("... " + paress);
		System.out.println("... " + imparess.toString());



		int p = lista1.size() / 2;

		System.out.println("..." + lista1.indexOf(p));
		//Muestra por consola el indice que corresponde al elemento p de la lista1, siempre y cuando la lista lo contenga.

		int c = 0;
		for (Integer n: lista1) {
			if (n > numero) {
				c = c + 1;
			}
		}
		if (c > lista1.size() / 2) {
			System.out.println("..."); //Si c es mayor que la mitad del tamaño de la lista1, muestra por consola ...
		} else if (c > 0) {
			System.out.println("..."); //Si c esta entre 1 y la mitad del tamaño de la lista1, muestra por consola ...
		} else {
			System.out.println("..."); //Si c es igual a 0, muestra por consola ...
		}
		//Sugerencia, para que tengan sentido los println, mostrar por consola algo que identifique cada caso.
	}

	/***
	 * @param lista1
	 * @param lista2
	 *
	 * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos
	 *
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO: corregir el metodo para que funcione correctamente

		List<Integer> union = new ArrayList<>();

		// union.addAll(lista1);

		for (Integer m: lista1) {
			if (!union.contains(m)) {
				union.add(m);
			}
		}

		for (Integer m: lista2) {
			if (!union.contains(m)) {
				union.add(m);
			}
		}

		return union;
	}

	/***
	 * @param lista1
	 * @param lista2
	 *
	 * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos
	 *
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {

		List<Integer> inter = new ArrayList<>();

		for (Integer elem : lista1)
			if (lista2.contains(elem) && !inter.contains(elem))
				inter.add(elem);

		return inter;
	}

	/***
	 * @param lista1
	 *
	 * retornar la lista recibida, ordenada en forma ascendente
	 *
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {

		List<Integer> ordAsc = new ArrayList<>(lista1);
		int mayor;
		Integer temp;

		for(int i = ordAsc.size() - 1; i > 0; i--) {
			mayor = 0;
			for (int j = 1; j <= i; j++)
				if (ordAsc.get(mayor) < ordAsc.get(j))
					mayor = j;
			temp = ordAsc.get(i);
			ordAsc.set(i,ordAsc.get(mayor));
			ordAsc.set(mayor, temp);
		}

		return ordAsc;
	}

	/***
	 * @param lista2
	 *
	 * retornar la lista recibida, ordenada en forma descendente
	 *
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {

		List<Integer> ordDes = new ArrayList<>(lista2);
		int mayor;
		Integer temp;

		for(int i = ordDes.size() - 1; i > 0; i--) {
			mayor = 0;
			for (int j = 1; j <= i; j++)
				if (ordDes.get(mayor) > ordDes.get(j))
					mayor = j;
			temp = ordDes.get(i);
			ordDes.set(i,ordDes.get(mayor));
			ordDes.set(mayor, temp);
		}

		return ordDes;
	}

	/***
	 * @param lista1
	 * @param lista2
	 *
	 * devuelve true si contienen los mismos elementos
	 * NO se considera valido que esten en diferente orden
	 * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente
	 *
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
		boolean iguales = false;
		int i = 0;

		if (lista1.size() != lista2.size())
			return iguales;

		while (i < lista1.size() && lista1.get(i) == lista2.get(i)) {
			i++;
		}

		if (i == lista1.size())
			iguales = true;

		return iguales;
	}

}
