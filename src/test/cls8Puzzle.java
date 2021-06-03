package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import recursos.clsNodoPuzzle;
import contenedores.clsArbolPuzzle;
import contenedores.clsEstado;

public class cls8Puzzle {

	public static void main(String[] args) {
		clsEstado estadoInicial=new clsEstado(3);
		clsEstado estadoFinal=new clsEstado(3);
		String ruta=new String("./8-puzzle/fichero.txt");
		//Carga el archivo en estadoInicial y estadoFinal
		stringToState(ruta,estadoInicial,estadoFinal);
				
		clsArbolPuzzle puzzle=new clsArbolPuzzle(new clsNodoPuzzle(estadoInicial), new clsNodoPuzzle(estadoFinal));
		puzzle.generaArbol();
		long startTime, endTime;
		
		startTime=System.nanoTime();
		puzzle.muestraBEA();
		endTime=System.nanoTime();
		long tiempoBEA = endTime-startTime;		

		startTime=System.nanoTime();
		puzzle.muestraBPF();
		endTime=System.nanoTime();
		long tiempoBPF = endTime-startTime;
		
		puzzle.muestraCamino();
		System.out.println("Tiempo en nanosegundos:\nTiempoBEA: " + tiempoBEA + "\tTiempoBPF: " + tiempoBPF);
		System.out.println("Tiempo en milisegundos:\nTiempoBEA: " + tiempoBEA*1e-6 + "\tTiempoBPF: " + tiempoBPF*1e-6);
	}
	
	public static BufferedReader getBuffered(String direccion){
		FileReader fr=null;
	    BufferedReader br=null;
	    try{
	         File Archivo=new File(direccion);
	        if(!Archivo.exists()){
	           System.out.println("Error, el archivo no existe");
	        }else{
	           fr=new FileReader(direccion);
	           br=new BufferedReader(fr);
	        }
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	    return br;
	}
	
	public static void stringToState(String ruta, clsEstado estadoInicial, clsEstado estadoFinal) {
		try{				
			BufferedReader br=getBuffered(ruta);
			String linea=br.readLine();
			int cuentaLineas=0;
			while(cuentaLineas<estadoInicial.getNroFilas() && linea!=null){
				String[] valor=linea.split(" ");
				for(int i=0;i<valor.length;i++){
					estadoInicial.actualizar(valor[i],cuentaLineas,i);
				}
				cuentaLineas++;
				linea=br.readLine();
			}
			cuentaLineas=0;
			while(cuentaLineas<estadoFinal.getNroFilas() && linea!=null){
				String[] valor=linea.split(" ");
				for(int i=0;i<valor.length;i++){
					estadoFinal.actualizar(valor[i],cuentaLineas,i);
				}
				cuentaLineas++;
				linea=br.readLine();
			}
		}catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
	}	
}
