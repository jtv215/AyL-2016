package org.lya.practica1.ejercicio2;

import java.util.Arrays;
import java.util.Scanner;

import org.lya.practica1.ejercicio1.SecuenciaEnteros;
import org.lya.utilidades.ControlTime;
/**Clase subSecuencia*/
public class Subsecuencia {
	static int suma = 0;
	static int ultimo = 0;
	static int primer = 0;
	public static double[] Tiempos = new double[10];

	public static void main(String[] args) {

		SecuenciaEnteros secuencia;
		int numElem;
		int rango;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = 0;
		double media = 0;

		System.out.println("Escribe el número de elementos de la secuencia: ");
		numElem = sc.nextInt();

		System.out.println("Escribe el rango: ");
		rango = sc.nextInt();

		secuencia = new SecuenciaEnteros(numElem, rango);
		for (int veces = 0; veces < 10; veces++) {
			ControlTime ctim = new ControlTime();
			SubsecuenciaFuerzaBruta(secuencia);
			Tiempos[veces] = ctim.finalTime();
		}
		Arrays.sort(Tiempos);
		for (int i = 0; i < 8; i++) {
			media += Tiempos[i];
		}
		media = media / 8;

		System.out.println("Fuerza Bruta es: " + media);

		for (int veces = 0; veces < 10; veces++) {
			ControlTime ctim = new ControlTime();
			SubsecuenciaMejorado(secuencia);
			Tiempos[veces] = ctim.finalTime();
		}

		Arrays.sort(Tiempos);

		for (int i = 0; i < 8; i++) {
			media += Tiempos[i];
		}
		media = media / 8;

		System.out.println("Secuencia Mejorada es: " + media);

		for (int veces = 0; veces < 10; veces++) {
			ControlTime ctim = new ControlTime();
			SubsecuenciaLineal(secuencia);
			Tiempos[veces] = ctim.finalTime();
		}

		Arrays.sort(Tiempos);

		for (int i = 0; i < 8; i++) {
			media += Tiempos[i];
		}
		media = media / 8;

		System.out.println("Algoritmo Lineal es: " + media);

	}
	/** metodo Fuerza Bruta*/
	  public static void SubsecuenciaFuerzaBruta(SecuenciaEnteros secuenciaProblema) {
			int sumaMax = 0;
			int secIni = 0;
			int secFin = 0;
			int sumaActual;

			int [] a = secuenciaProblema.getValoresSecuencia();

			for(int i = 0;i<a.length;i++){
				for(int j=i;j<a.length;j++){
					sumaActual=0;
					for(int k=i;k<a.length;k++){
						sumaActual=sumaActual+a[k];

					if(sumaActual>sumaMax){
						sumaMax = sumaActual;
						secIni = i;
						secFin = k;
					}
					}
				}
			}
			suma = sumaMax;
			primer=secIni;
			ultimo=secFin;

		}

/** metodo subsecuencia Mejorado*/
		public static void SubsecuenciaMejorado(SecuenciaEnteros secuenciaProblema) {
			int sumaActual;
			int sumaMax=0;
			int secIni = 0;
			int secFin = 0;
			int [] a = secuenciaProblema.getValoresSecuencia();

			for (int i = 0; i < a.length; i++){
				sumaActual=0;

				for(int j=i; j<a.length;j++){
					sumaActual=sumaActual+a[j];

					if(sumaActual>sumaMax){
						sumaMax=sumaActual;
						secIni=i;
						secFin=j;
					}
				}

			}
			suma = sumaMax;
			primer=secIni;
			ultimo=secFin;
		}


/**método lineal*/
	public static void SubsecuenciaLineal(SecuenciaEnteros secuenciaProblema) {
	int sumaMax = 0;
	int sumaActual = 0;
	int secIni = 0;
	int secFin = 0;
	int [] a = secuenciaProblema.getValoresSecuencia();
	for(int i = 0, j = 0; j < a.length; j++){
				sumaActual += a[j];

				if(sumaActual > sumaMax){
					sumaMax = sumaActual;
					secIni = i;
					secFin = j;
				}else if(sumaActual < 0){
					i = j + 1;
					sumaActual = 0;
				}
			}
			suma = sumaMax;
			primer=secIni;
			ultimo=secFin;
		}
/** te devuelve suma*/
	public static int getSuma() {
	return suma;
		}
/** te devuelve ultimo*/
	public static int getUltimo() {
	return ultimo;
	}
/** te devuelve primer*/
	public static int getPrimer() {
	return primer;
		}

}