package org.lya.practica2.ejercicio1;

import java.util.Arrays;

import org.lya.utilidades.NumerosAleatorios;

public class Exponente {
	private int Base;
	private int Exponente;
	/**
	 * Calcula el tiempo medio de los 10 tiempos que realiza el algoritmo.
	 * @param tiempos parámetro de lo que tarda el algoritmo en nanosegundos
	 * @return Devuelve la media de los 10 tiempos
	 */

	public static void main (String[] args){
		double j=0;
		double k=0;
		/**
		 * El main calcula con un for el tiempo del algoritmo de fuerza bruta y el de divide y vencerás con
		 * un tamaño desde 128 a 8192 con una base de valor aleatorio comprendida de 2 a 10.
		 */
		int numRepe=10;
		System.out.println("Tamaño     Fuerza Bruta     Recursivo");

		for (int n=128; n<=8192; n=n*2){
			long [] t1 = new long [numRepe];
			long [] t2 = new long [numRepe];
			for (int i=0; i<numRepe; i++){
				int a = (int) (Math.random()*(10-2+1)) + 2;

				Exponente e = new Exponente (a, n);
				long tantes = System.nanoTime();
				 j=e.exponenFuerzaBruta();
				long tdespues = System.nanoTime();
				t1[i] = tdespues - tantes;
				tantes = System.nanoTime();
				k=e.exponenRecursivoDyV();
				tdespues=System.nanoTime();
				t2[i] = tdespues - tantes;
			}
				Arrays.sort(t1);
				long sum1=0;
				for (int i=0; i<numRepe-2; i++)
					sum1=sum1 + t1[i];
				long med1=sum1/(numRepe-2);
				Arrays.sort(t2);
				long sum2=0;
				for (int i=0; i<numRepe-2; i++)
					sum2=sum2+t2[i];
				long med2=sum2/(numRepe-2);
				System.out.println("   "+ n + "       "+med1+"          "+ med2+"     "+k);
			}
		}

	/**
	 *  Constructor que pasa los valores de la base y el exponente
	 * @param i valor de la base
	 * @param j valor del exponente
	 */
	public Exponente(int i, int j) {
		Base = i;
		Exponente = j;
	}

	/**
	 * Constructor que pasa a la base entre un valor minimo y otro superior y el valor del exponente.
	 * @param e valor del exponente
	 */
	public Exponente(int e, int linf, int lsup){
		NumerosAleatorios numRand = new NumerosAleatorios();
		this.Base = numRand.randomInt(linf, lsup);
		this.Exponente=e;
	}
	/**
	 * Algoritmo que multiplica la base el nº de veces que tiene el valor del exponente
	 * @return el numero calculado entre si n veces
	 */
	public double exponenFuerzaBruta() {

		if(Exponente==0) return (1.0);
		else if(Exponente==1)return this.Base;

		int numero = this.Base;
		for(int i=0;i<Exponente-1; i++){
			numero*=this.Base;
		}
		return numero;
	}
	/**
	 * Metodo que llama al exponente recursivo
	 * @return llamada al metodo exponenRecursivoDyV
	 */
	public double exponenRecursivoDyV() {

		return(exponenRecursivoDyV(Base, Exponente));
	}

	/**
	 * Algoritmo que calcula un numero par e impar n veces de forma más eficiente.
	 * @return Para el caso de numeros pares devuelve el numero elevado a n/2 y multiplicado por 2. Y si
	 * es impar devuelve el numero multiplicado por n veces -1 y multiplicandolo una vez mas por la base.
	 */
	public static double exponenRecursivoDyV(int a, int n){

		if(n==1)
			return(a);
		if(n==0) return (1.0);

		if(n%2==0){
			return (Math.pow(exponenRecursivoDyV(a, n/2) , 2.0));
		}
		else{
			return (a*exponenRecursivoDyV(a, n-1));
			}
		}

	/**
	 * Cambia el valor del exponente
	 * @param expon devuelve el nuevo valor del exponente
	 */
	public void setExpon(int expon) {
		this.Exponente = expon;
	}

	/**
	 * Devuelve el valor de la base
	 */
	public int getBase() {
		return Base;
	}

	/**
	 * Devuelve el valor del exponente
	 */
	public int getExponente() {
		return Exponente;
	}
}
