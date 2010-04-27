/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadoraestructuras;
//import calculadoraestructuras.Nodo;

/**
 *
 * @author andrewwolff
 */
public class UsoDeArbol {

    Nodo nuevo;

public void insertarRaiz(String Info)
{
    nuevo.info=new String(Info);
}
//String Info, Nodo izq, Nodo der, Nodo root
public void insertar(String Info, Nodo izq, Nodo der, Nodo root)
{
       
    nuevo.info=new String(Info);
    
     if(root.izq==null)//Si el puntero izquierdo del padre esta vacio
        {
            nuevo.raiz=root.izq;       //Establece que la raiz del nodo actual es el puntero izquierdo del padre
            root.izq=new Nodo(Info,izq,der,nuevo.raiz);       //Establece que el puntero izquierdo del nodo padre apuntara a la raiz del nodo hijo izquerdo
        }else if (root.der==null)//En caso contrario, si el puntero derecho del padre esta vacio
        {
            nuevo.raiz=root.der;       //establece que la raiz del nodo actual es el puntero derecho del pade
            root.der=nuevo.raiz;       //establece que el puntero derecho del padre, apuntara a la direccion de memoria del hijo derecho
        }else
            insertar(Info,izq,der,root);//Si no es ninguno de los dos anteriores, que vuelva a ejecutar recursivamente el mismo metodo para volver a buscar

    //INSERTAR AQUI LOS METODOS PROGRAMADOS EN EL CONSTRUCTOR PARA ASIGNAR ESOS VALORES A CADA ATRIBUTO, PERO DESDE AQUI.
    
        /*if(nuevo.izq==null)
        {

        //    nuevo.izq=new nNodo;
        }
        else if(nuevo.der==null)
        {
            
        }*/


}
}