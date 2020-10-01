//Autor: Alonso Moreno Zamora (⌐■_■)
package arboles;
import java.util.Random;

public class PruebaArbol{
    
    public static void main( String args[] ){
        Arbol arbol = new Arbol();
        int valor;
        Random numeroAleatorio = new Random();
        
//------------------------------------------------------------------------------        
        
        //Lo que vamos ah hacer aqui es que vamos a insertar el nodo 2
            arbol.insertarNodo(2);
        /*Si solo estubiera el de insertar, el 2 apareceria cada vez que corramos
        //el programa, asi que ocuparemos eliminar para quitarlo*/
            arbol.eliminar(2);
        //Si quiere hacer la prueva, quite la linea de codigo de aqui arriba
        
//------------------------------------------------------------------------------       
        
        System.out.println( "Insertando los siguientes valores: " );
        // inserta 10 enteros aleatorios de 0 a 99 en arbol
        for ( int i = 1; i <= 10; i++ ){
            valor = numeroAleatorio.nextInt( 100 );
            System.out.print( valor + " " );
            arbol.insertarNodo( valor );
        } // fin de for
        System.out.println ( "\n\nRecorrido preorden" );
        arbol.recorridoPreorden(); // realiza recorrido preorden de arbol
        System.out.println ( "\n\nRecorrido inorden" );
        arbol.recorridoInorden(); // realiza recorrido inorden de arbol
        System.out.println ( "\n\nRecorrido postorden" );
        arbol.recorridoPostorden(); // realiza recorrido postorden de arbol
        System.out.println();
    } // fin de main
} // fin de la clase PruebaArbol
