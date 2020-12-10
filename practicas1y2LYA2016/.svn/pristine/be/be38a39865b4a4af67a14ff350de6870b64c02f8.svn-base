package org.lya.practica2.ejercicio2;

import java.util.Arrays;

public class CoeficienteBin {

	public static void main (String[] args){

		int numRepeticiones=10;
		int a = 8;

		System.out.println("Tamaño     BinRecursivo     ProgDinam");

		/**
		 * El main calcula con un for el tiempo del algoritmo de coeficiente binomial recursivo y el de
		 * coeficiente binomial dinamico con un tamaño desde 4 a 25 con una base de valor 2N, es decir, el
		 * doble del valor del exponente.
		 */
		for (int n=4; n<=25; n++){
			long [] tiempo1 = new long [numRepeticiones];
			long [] tiempo2 = new long [numRepeticiones];
			a = n*2;
			for (int i=0; i<numRepeticiones; i++){
				CoeficienteBin e = new CoeficienteBin (a, n);
				long tantes = System.nanoTime();
				e.coefBinomialRecursivo();
				long tdespues = System.nanoTime();
				tiempo1[i] = tdespues - tantes;
				tantes = System.nanoTime();
				e.coefBinomialProgDinam();
				tdespues=System.nanoTime();
				tiempo2[i] = tdespues - tantes;


			}
				Arrays.sort(tiempo1);
				long sum1=0;
				for (int i=0; i<numRepeticiones-2; i++)
					sum1=sum1 + tiempo1[i];
				long med1=sum1/(numRepeticiones-2);
				Arrays.sort(tiempo2);
				long sum2=0;
				for (int i=0; i<numRepeticiones-2; i++)
					sum2=sum2+tiempo2[i];
				long med2=sum2/(numRepeticiones-2);
				System.out.printf("%1d %1d %16d %13d\n",a, n , med1, med2);
			}
		}

	private int k;
	private int n;

	/**
	 * Constructor que pasa los valores de la base y el exponente.
	 * @param i valor de la base
	 * @param j valor del exponente
	 */
	public CoeficienteBin(int i, int j) {
		this.k=j;
		this.n=i;
	}

	/**
	 * Método que llama al algoritmo recursivo
	 * @return llama al método coefBinRec
	 */
	public int coefBinomialRecursivo() {
		if(k>n) return 0;
		return coefBinRec(n, k);
	}

	/**
	 * Algoritmo que calcula un problema dicidiendolo en problemas más pequeños haciendolo más eficiente.
	 * @param n valor de la base
	 * @param k valor del exponente
	 * @return coefBinRec(n-1, k-1) + coefBinRec(n-1, k)
	 */
	public static int coefBinRec(int n, int k){
		if(k==0||k==n)
			return 1;
		return coefBinRec(n-1, k-1) + coefBinRec(n-1, k);
	}

	/**
	 * s un método para reducir el tiempo de ejecución de un algoritmo mediante la utilización de
	 * subproblemas superpuestos y subestructuras óptimas
	 * @return Devuelve la matriz calculada de la base y el exponente.
	 */
	public int coefBinomialProgDinam() {
		int [][] matriz =new int [n+1][n+1];
		if(k>n) return 0;
		for(int i=0;i<=n;i++)
			for(int j=0;j<=i;j++)
				if(j==0)
					matriz[i][j]=1;
				else
					matriz[i][j]= matriz [i-1][j-1]+ matriz[i-1][j];
		return matriz[n][k];
	}

	/**
	 * Devuelve el nuevo valor del exponente
	 * @param i valor nuevo del exponente
	 */
	public void setK(int i) {
		this.k = i;
	}

	/**
	 * Devuelve el nuevo valor de la base
	 * @param i valor nuevo de la base
	 */
	public void setN(int i) {
		this.n = i;
	}
}
