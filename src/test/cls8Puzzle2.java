package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import contenedores.*;
import recursos.*;

public class cls8Puzzle2 {

	public static void main(String[] args) {
		clsEstado estadoInicial=new clsEstado(3);
		clsEstado estadoFinal=new clsEstado(3);
		//Carga del archivo de texto
		try{
			String ruta=new String("/home/favio/fichero1.txt");
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

		long tiempoIni, tiempoFin, tiempoBEA, tiempoBPF;
		long nodosBEA=0, nodosBPF=0;/*nodos analizados*/
		long nivelBEA=0, nivelBPF=0;/*profundidad del nodo final*/

		System.out.println("Mostrando Busqueda en Anchura: ");
		tiempoIni=System.currentTimeMillis();
		clsPila_Link pilaux= new clsPila_Link();
		if(!estadoInicial.estaCompleto()){
			System.out.println("Error, el estado inicial no se carg� correctamente");
		}
		else if(!estadoFinal.estaCompleto()){
			System.out.println("Error, el estado final no se carg� correctamente");
		}
		else{
			clsNodoPuzzle aux=new clsNodoPuzzle(estadoInicial);
			
			clsEstadoSet conjunto=new clsEstadoSet();
			clsCola_Link cola=new clsCola_Link();
			cola.meter(aux);
			while(!cola.estaVacia()){
				aux=(clsNodoPuzzle)cola.sacar();
				aux.getEstado().muestraEstado();
				nodosBEA++;
				System.out.println("\t\t\t"+nodosBEA);
				if(aux.getEstado().equals(estadoFinal)){
					cola.limpiar();
				}
				else if(!conjunto.pertenece(aux.getEstado())){
					conjunto.meter(aux.getEstado());
					aux.generarSucesores();
					for(int i=0;i<aux.getListaHijos().tamanio();i++){
						cola.meter(aux.getHijo(i));
//						if(!conjunto.pertenece(aux.getHijo(i).getEstado())){
//						}
//						else{
//							aux.getListaHijos().eliminar(i);
//						}
						
					}
				}
			}
			if(aux.getEstado().equals(estadoFinal)){
				while(aux!=null){
					nivelBEA++;
					pilaux.meter(aux);
					aux=aux.getPadre();
				}
				System.out.println("\nCamino a la soluci�n");
//				MuestraCamino(aux);
			}
			else{
				System.out.println("\nNo se encontr� una soluci�n");
			}
		}
		tiempoFin=System.currentTimeMillis();
		tiempoBEA=tiempoFin-tiempoIni;
		
		System.out.println("Mostrando Busqueda en Profundidad: ");
		tiempoIni=System.currentTimeMillis();
		clsPila_Link pilaux2= new clsPila_Link();
		if(!estadoInicial.estaCompleto()){
			System.out.println("Error, el estado inicial no se carg� correctamente");
		}
		else if(!estadoFinal.estaCompleto()){
			System.out.println("Error, el estado final no se carg� correctamente");
		}
		else{
			clsNodoPuzzle aux=new clsNodoPuzzle(estadoInicial);
			
			clsEstadoSet conjunto=new clsEstadoSet();
			clsPila_Link pila=new clsPila_Link();
			pila.meter(aux);
			while(!pila.estaVacia()){
				aux=(clsNodoPuzzle)pila.sacar();
				aux.getEstado().muestraEstado();
				nodosBPF++;
				System.out.println("\t\t\t"+nodosBPF);
				if(aux.getEstado().equals(estadoFinal)){
					pila.limpiar();
				}
				else if(!conjunto.pertenece(aux.getEstado())){
					conjunto.meter(aux.getEstado());
					aux.generarSucesores();
					for(int i=0;i<aux.getListaHijos().tamanio();i++){
						pila.meter(aux.getHijo(i));
//						if(!conjunto.pertenece(aux.getHijo(i).getEstado())){
//						}
//						else{
//							aux.getListaHijos().eliminar(i);
//						}
					}
				}
			}
			if(aux.getEstado().equals(estadoFinal)){
//				MuestraCamino(aux);
				while(aux!=null){
					nivelBPF++;
					pilaux2.meter(aux);
					aux=aux.getPadre();
					
				}
				
			}
			else{
				System.out.println("No se encontr� una soluci�n");
			}
		}
		tiempoFin=System.currentTimeMillis();
		tiempoBPF=tiempoFin-tiempoIni;
		
		System.out.println("Busqueda en Anchura: ");
		System.out.println("Tiempo de Computo: "+tiempoBEA+"ms");
		System.out.println("Tiempo de Computo: "+tiempoBEA/1000+"seg");
		System.out.println("Nodos analizados: "+nodosBEA);
		System.out.println("Nivel: "+nivelBEA); 
		//MostrarCamino(pilaux);

		
		System.out.println("Busqueda en Profundidad: ");
		System.out.println("Tiempo de Computo: "+tiempoBPF+"ms");
		System.out.println("Tiempo de Computo: "+tiempoBPF/1000+"seg");
		System.out.println("Nodos analizados: "+nodosBPF);
		System.out.println("Nivel: "+nivelBPF); 
		//MostrarCamino(pilaux2);
		
	}
	
	public static void MostrarCamino(clsPila_Link pila){
		clsNodoPuzzle aux;
		System.out.println("\nEl camino es el siguiente");
		while(!pila.estaVacia()){
			aux=(clsNodoPuzzle)pila.sacar();
			aux.getEstado().muestraEstado();
		}
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

}
