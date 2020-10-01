//Autor: Alonso Moreno Zamora (⌐■_■)
package arboles;

public class NodoArbol {
    // miembros de acceso del paquete
    NodoArbol nodoIzq; // nodo izquierdo
    int datos; // valor del nodo
    NodoArbol nodoDer; // nodo derecho

    // el constructor inicializa los datos y hace de este nodo un nodo raíz
    public NodoArbol( int datosNodo ){
        datos = datosNodo;
        nodoIzq = nodoDer = null; // el nodo no tiene hijos
    } // fin del constructor de NodoArbol

    // localiza el punto de inserción e inserta un nuevo nodo; ignora los valores duplicados
    public void insertar( int valorInsertar ){
        // inserta en el subárbol izquierdo
        if ( valorInsertar < datos ){
            // inserta nuevo NodoArbol
                if ( nodoIzq == null )
                    nodoIzq = new NodoArbol( valorInsertar );
                else // continúa recorriendo el subárbol izquierdo
                    nodoIzq.insertar( valorInsertar );
        } // fin de if
        // inserta en el subárbol derecho 
        else if ( valorInsertar > datos ){
            // inserta nuevo NodoArbol
            if ( nodoDer == null )
                nodoDer = new NodoArbol( valorInsertar );
            else // continúa recorriendo el subárbol derecho
                nodoDer.insertar( valorInsertar );
        } // fin de else if
    } // fin del método insertar    
}    