/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;
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
}

//Este es el recursivo
public String postorden(Nodo p)
    {
        if(p==null)
            return null ;
       postorden(p.izq);
       postorden(p.der);
       return p.info;
    }
//Este es el no recursv o
public void postorden()
{
    Nodo p=raiz, q=raiz;
    Stack pila = new Stack();
    while (p!=null){
        for(; p.izq!=null;p = p.izq)
            pila.push(p);
        while(p! = null && (p.der==null || p.der==q)){
            visi(p); //Este solo imprime la info del nodo
            q=p;
            if(pila.isEmpty())
                return;
            p=(Nodo)pila.pop();
        }
        pila.push(p);
        p=p.der;
    }
}

    //INSERTAR AQUI LOS METODOS PROGRAMADOS EN EL CONSTRUCTOR PARA ASIGNAR ESOS VALORES A CADA ATRIBUTO, PERO DESDE AQUI.
    
        /*if(nuevo.izq==null)
        {

        //    nuevo.izq=new nNodo;
        }
        else if(nuevo.der==null)
        {
            
        }*/


}
