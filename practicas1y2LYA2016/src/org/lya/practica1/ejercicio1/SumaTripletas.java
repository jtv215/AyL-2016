package org.lya.practica1.ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

import org.lya.utilidades.ControlTime;

public class SumaTripletas {

public static void main(String[] args) {

int tamano = 0;
int rango = 0;
double tiempoMedio = .0;
Scanner entrada = new Scanner(System.in);
double[] tiempos = new double[10];
double[] tiempos2 = new double[1];
SumaTripletas sumar = new SumaTripletas();
String tripletas = "";
int numTripletas = 0;

System.out.print("Elige el Tamaño del array: ");
	tamano = entrada.nextInt();
	System.out.print("Elige el Rango del array: ");
		rango = entrada.nextInt();

		SecuenciaEnteros sec = new SecuenciaEnteros(tamano, rango);

		System.out.println("Elige 1(mostrar tripletas):\nElige 2(Buscar y mostrar los tiempos de ejecución): ");
		int numero = entrada.nextInt();

		if (numero == 1) {
			tripletas = MuestraTripletas(sec);
		} else if (numero == 2) {
			for (int i = 0; i < 10; i++) {
				ControlTime controlt = new ControlTime();
				numTripletas = tripletaSumCount(sec);
				tiempos[i] = controlt.finalTime();
			}
			System.out.println("Número de tripletas encontradas: " + numTripletas);
			String tiempo = "";
			Arrays.sort(tiempos);
			for (int i = 0; i < 10; i++) {
				tiempo += tiempos[i] + " ";
			}
			System.out.println(tiempo + "\n");

			System.out.println(
					"La media de los 9 tiempos mas pequeños es de: " + calculaTiempoMedio(tiempos) + " segundos.");
		}
	}

	/** muestra tripleta */
	public static String MuestraTripletas(SecuenciaEnteros secuenciaProblema) {
		double[] ArrayTiempos = new double[1];
		String salidaTripletas = "";
		int[] memoria = secuenciaProblema.getValoresSecuencia();

		ControlTime ct2 = new ControlTime();
		for (int i = 0; i < secuenciaProblema.getNumeroElementos(); i++)
			for (int j = i + 1; j < secuenciaProblema.getNumeroElementos(); j++)
				for (int k = j + 1; k < secuenciaProblema.getNumeroElementos(); k++)
					if (memoria[i] + memoria[j] + memoria[k] == 0) {
						salidaTripletas = memoria[i] + " " + memoria[j] + " " + memoria[k];

						// System.out.println(salidaTripletas);
					}
		ArrayTiempos[0] = ct2.finalTime();
		System.out.println("Tiempo que ha tardado en imprimir las tripletas: " + ArrayTiempos[0]);

		return salidaTripletas;
	}

	/** tripletaSumCount */
	public static int tripletaSumCount(SecuenciaEnteros valor) {

		int num = 0;
		int[] espacioAuxiliar = valor.getValoresSecuencia();
		for (int i = 0; i < valor.getNumeroElementos(); i++) {
			for (int j = i + 1; j < valor.getNumeroElementos(); j++) {
				for (int k = j + 1; k < valor.getNumeroElementos(); k++) {
					if (espacioAuxiliar[i] + espacioAuxiliar[j] + espacioAuxiliar[k] == 0)
						num++;
				}
			}
		}

		return (num++);
	}

	/** calcular el tiempo medio */
	public static double calculaTiempoMedio(double[] tiempos) {
		double resul = 0;
		Arrays.sort(tiempos);
		for (int i = 0; i < 9; i++)
			resul += tiempos[i];
		return resul / 9;
	}

}