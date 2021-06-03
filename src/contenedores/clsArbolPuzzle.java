package contenedores;

import recursos.*;

public class clsArbolPuzzle implements OperacionesG{
	clsNodoPuzzle nodoRaiz;
	clsNodoPuzzle nodoSolucion;
	clsListaNodoPuzzle camino;

	public clsArbolPuzzle(clsNodoPuzzle nodoRaiz, clsNodoPuzzle nodoSolucion){
		this.nodoRaiz=nodoRaiz;
		this.nodoSolucion=nodoSolucion;
		this.camino=new clsListaNodoPuzzle();
	}
	
	public void setNodoRaiz(clsNodoPuzzle estadoInicial){
		this.nodoRaiz=estadoInicial;
	}
	
	public clsNodoPuzzle getNodoRaiz(){
		return this.nodoRaiz;
	}
	
	public void setNodoSolucion(clsNodoPuzzle nodoSolucion){
		this.nodoSolucion=nodoSolucion;
	}
	
	public clsNodoPuzzle getNodoSolucion(){
		return this.nodoSolucion;
	}
	
	public void limpiarArbol(){
		this.nodoRaiz=null;
		this.nodoSolucion=null;
		this.camino.limpiar();
	}
	
	public void generaArbol(){
		generaArbol(0);
	}
	
	public void generaArbol(int cota){
		if(!this.nodoRaiz.getEstado().estaCompleto()){
			System.out.println("Error al generar arbol, el estado inicial no se cargó correctamente");
		}
		else if(!this.nodoSolucion.getEstado().estaCompleto()){
			System.out.println("Error al generar arbol, el estado final no se cargó correctamente");
		}
		else{
			clsCola_Link cola=new clsCola_Link();
			clsNodoPuzzleSet conjunto=new clsNodoPuzzleSet();
			clsNodoPuzzle aux=this.nodoRaiz;
			int j=0;
			cola.meter(aux);
			while(!cola.estaVacia() && (cota==0 || conjunto.cardinal<=cota)){
				aux=(clsNodoPuzzle)cola.sacar();
				if(this.nodoSolucion.equals(aux)){
					cola.limpiar();
				}
				else if(!conjunto.pertenece(aux)){
					aux.getEstado().muestraEstado();
					System.out.println("\t\t\t"+j++);
					conjunto.meter(aux);
					aux.generarSucesores();
					meterSucesoresCola(aux, cola);
				}
				else{
					int i;
					clsNodoPuzzle temp=aux.getPadre();
					i=temp.getListaHijos().buscar(aux);
					temp.getListaHijos().eliminar(i);
				}
			}
			if(this.nodoSolucion.equals(aux)){
				this.nodoSolucion=aux;
				this.camino=new clsListaNodoPuzzle();
				while(aux!=null){
					camino.insertar(aux, 0);
					aux=aux.getPadre();
				}
			}
			else{
				System.out.println("No se encontró una solución");
			}
		}
	}
	
	public void muestraBEA() {
		if(this.nodoSolucion.getPadre()==null){
			System.out.println("Error mostrar, el arbol no esta generado");
		}
		else{
			clsCola_Link nodoshoja=new clsCola_Link();
			clsNodoPuzzle aux=null;
			nodoshoja.meter(this.nodoRaiz);
			System.out.println("Busqueda en Anchura: ");
			while(!nodoshoja.estaVacia()){
				aux=(clsNodoPuzzle)nodoshoja.sacar();
				aux.getEstado().muestraEstado();
				if(this.nodoSolucion.equals(aux)){
					nodoshoja.limpiar();
				}
				else if(!aux.getListaHijos().estaVacia()){
					meterSucesoresCola(aux, nodoshoja);
				}
				
			}
		}
	}
	
	public void muestraBPF() {
		if(this.nodoSolucion.getPadre()==null){
			System.out.println("Error mostrar, el arbol no esta generado");
		}
		else{
			clsPila_Link nodoshoja=new clsPila_Link();
			clsNodoPuzzle aux=null;
			nodoshoja.meter(this.nodoRaiz);
			System.out.println("Busqueda en Profundidad: "); 
			while(!nodoshoja.estaVacia()){
				aux=(clsNodoPuzzle)nodoshoja.sacar();
				aux.getEstado().muestraEstado();
				if(this.nodoSolucion.equals(aux)){
					nodoshoja.limpiar();
				}
				else if(!aux.getListaHijos().estaVacia()){
					meterSucesoresPila(aux,nodoshoja);
				}
				
			}
		}
	}
	
	private void meterSucesoresCola(clsNodoPuzzle nodo, clsCola_Link cola){
		for(int i=0;i<nodo.getListaHijos().tamanio();i++){
			cola.meter(nodo.getHijo(i));
		}
	}
	
	private void meterSucesoresPila(clsNodoPuzzle nodo, clsPila_Link pila){
		for(int i=0;i<nodo.getListaHijos().tamanio();i++){
			pila.meter(nodo.getHijo(i));
		}
	}
	
	public void muestraCamino(){
		if(this.camino.estaVacia()){
			System.out.println("Error mostrar camino, el camino no existe");
		}
		else{
			clsNodoPuzzle aux=this.nodoRaiz;
			System.out.println("Camino solución: ");
			for(int i=0;i<this.camino.tamanio();i++){
				aux=(clsNodoPuzzle) this.camino.devolver(i);
				aux.getEstado().muestraEstado();
			}
		}
	}
}
