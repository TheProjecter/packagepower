/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadoraestructuras;

/**
 *
 * @author andrewwolff
 */
public class Nodo {

    public
    String info;    //El atributo info es el que almacenara el contenido
    //private
    Nodo raiz;
    Nodo izq;       //El atributo que apuntara a su hijo izquierdo
    Nodo der;       //El atributo que apuntara a su hijo derecho

    //Constructor Nodo para insertar la raiz del arbol
    public Nodo(String item)
    {
        info = item;
        raiz=izq=der=null;

    }

    public Nodo(String Item,Nodo Izqui,Nodo Root)
    {
        info = new String(Item);
        izq=Izqui;
        raiz=Root;
        der=null;
    }

    //Constructor para darle las propiedades a cada nodo nuevo insertado
    //Esblece que el nodo sera una hoja en su declaracion pero con contenido item
    public Nodo(String item, Nodo izqui, Nodo dere, Nodo root)
    {
        info=new String(item);  //Establece que el atributo info del nuevo nodo contendra lo que se le pase en item
        izq=izqui;
        der=dere;
        raiz=root;

        /*if(root.izq==null)//Si el puntero izquierdo del padre esta vacio
        {
            raiz=root.izq;       //Establece que la raiz del nodo actual es el puntero izquierdo del padre
            root.izq=raiz;       //Establece que el puntero izquierdo del nodo padre apuntara a la raiz del nodo hijo izquerdo
        }else if (root.der==null)//En caso contrario, si el puntero derecho del padre esta vacio
        {
            raiz=root.der;       //establece que la raiz del nodo actual es el puntero derecho del pade
            root.der=raiz;       //establece que el puntero derecho del padre, apuntara a la direccion de memoria del hijo derecho
        }*/
    }

}
