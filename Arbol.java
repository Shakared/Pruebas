//Autor: Alonso Moreno Zamora (⌐■_■)
package arboles;
// definición de la clase Arbol
public class Arbol {
    private NodoArbol raiz;
    // el constructor inicializa un Arbol vacío de enteros
    public Arbol(){
        raiz = null;
    } // fin del constructor de Arbol sin argumentos
    // inserta un nuevo nodo en el árbol de búsqueda binaria
    public void insertarNodo( int valorInsertar ){
        if ( raiz == null )
            raiz = new NodoArbol( valorInsertar ); // crea el nodo raíz aquí
        else
            raiz.insertar(valorInsertar ); // llama al método insertar
    } // fin del método insertarNodo
    // Elimina un nuevo nodo en el árbol de búsqueda binaria
    
     // fin del método eliminarNodo    
    //comienza el recorrido preorden
    public void recorridoPreorden(){
        ayudantePreorden( raiz );
     } // fin del método recorridoPreorden
    // método recursivo para realizar el recorrido preorden
    private void ayudantePreorden( NodoArbol nodo ){
        if ( nodo == null )
            return;
            System.out.printf( "%d ", nodo.datos ); // imprime los datos del nodo
            ayudantePreorden( nodo.nodoIzq ); // recorre el subárbol izquierdo
            ayudantePreorden( nodo.nodoDer ); // recorre el subárbol derecho
    } // fin del método ayudantePreorden
    // comienza recorrido inorden
    public void recorridoInorden(){
        ayudanteInorden( raiz );
    } // fin del método recorridoInorden
    // método recursivo para realizar el recorrido inorden
    private void ayudanteInorden( NodoArbol nodo ){
        if ( nodo == null )
            return;
            ayudanteInorden( nodo.nodoIzq ); // recorre el subárbol izquierdo
            System.out.printf( "%d ", nodo.datos ); // imprime los datos del nodo
            ayudanteInorden( nodo.nodoDer ); // recorre el subárbol derecho
    } // fin del método ayudanteInorden
    // comienza recorrido postorden
    public void recorridoPostorden(){
        ayudantePostorden( raiz );
    } // fin del método recorridoPostorden
    // método recursivo para realizar el recorrido postorden
    private void ayudantePostorden( NodoArbol nodo ){
        if ( nodo == null )
            return;
            ayudantePostorden( nodo.nodoIzq ); // recorre el subárbol izquierdo
            ayudantePostorden( nodo.nodoDer ); // recorre el subárbol derecho
            System.out.printf( "%d ", nodo.datos ); // imprime los datos del nodo
    } // fin del método ayudantePostorden
    public boolean eliminar(int d){
        NodoArbol aux=raiz;
        NodoArbol padre=raiz;
        boolean hijoizq=true;
        while(aux.datos!=d){
            padre=aux;
           if(d<aux.datos){
               hijoizq=true;
               aux=aux.nodoIzq;
           }
           else{
               hijoizq=false;
               aux=aux.nodoDer;
           }
           if(aux==null){
               return false;
           }
        }//fin del while
        if(aux.nodoIzq==null&&aux.nodoDer==null){
            if(aux==raiz)
                raiz=null;
            else
                if(hijoizq)
                    padre.nodoIzq=null;
                else
                    padre.nodoDer=null;
        }
        else
            if(aux.nodoDer==null){
                if(aux==raiz)
                    raiz=aux.nodoIzq;
                else
                    if(hijoizq)
                        padre.nodoIzq=aux.nodoIzq;
                    else
                        padre.nodoDer=aux.nodoIzq;
            }
        else
            if(aux.nodoIzq==null){
                if(aux==raiz)
                    raiz=aux.nodoDer;
                else
                    if(hijoizq)
                        padre.nodoIzq=aux.nodoDer;
                    else
                        padre.nodoDer=aux.nodoDer;
            }
        else{
            NodoArbol reemplazo = obtenerNodoReemplazo(aux);  
            if(aux==raiz)
                raiz=reemplazo;
            else
                if(hijoizq)
                    padre.nodoIzq=reemplazo;
                else
                    padre.nodoDer=reemplazo;
            reemplazo.nodoIzq=aux.nodoIzq;
            }
        return true;
        }
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp){
            NodoArbol reemplazarPadre=nodoReemp;
            NodoArbol reemplazo=nodoReemp;
            NodoArbol auxiliar=nodoReemp.nodoDer;
            while(auxiliar!=null){
                reemplazarPadre=reemplazo;
                reemplazo=auxiliar;
                auxiliar=auxiliar.nodoIzq;
            }
            if(reemplazo!=nodoReemp.nodoDer){
                reemplazarPadre.nodoIzq=reemplazo.nodoDer;
                reemplazo.nodoDer=nodoReemp.nodoDer;
            }
            System.out.println("El Nodo reemplazo es: "+ reemplazo);
            return reemplazo;
    }
}// fin de la clase Arbol    