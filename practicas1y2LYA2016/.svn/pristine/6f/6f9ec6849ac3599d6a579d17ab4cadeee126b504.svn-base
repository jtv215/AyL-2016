package org.lya.practica1.ejercicio1;
import org.lya.utilidades.*;

/**clase secuenciaEnteros*/
public class SecuenciaEnteros {

/** atributos */
	private int numeroElementos;
	private int[] valoresSecuencia;

	public SecuenciaEnteros(int[] datos) {
		valoresSecuencia = datos;
		numeroElementos = datos.length;
	}

	public SecuenciaEnteros(int nuemerosElementos, int rango) {
		valoresSecuencia = new int[nuemerosElementos];
		numeroElementos = nuemerosElementos;
		NumerosAleatorios nAleatorio = new NumerosAleatorios();
			for(int i=0; i<numeroElementos; i++){
				valoresSecuencia[i]= nAleatorio.randomInt(rango*-1, rango);
			}
	}

	public int getNumeroElementos() {
		return numeroElementos;
	}

	public void setNumeroElementos(int numeroElementos) {
		this.numeroElementos = numeroElementos;
	}

	public int[] getValoresSecuencia() {
		return valoresSecuencia;
	}

	public void setValoresSecuencia(int[] valoresSecuencia) {
		this.valoresSecuencia = valoresSecuencia;
	}

}