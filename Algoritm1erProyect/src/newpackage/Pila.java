/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

/**
 *
 * @author arturo88
 */
public class Pila {
    private int [] dato;
    private int tope,indice;

public Pila(int tamaño)
{
    indice=0;
    tope=tamaño-1;
    dato=new int[tamaño];
}
public boolean estaVacia()
{
    return(indice==0);
}
public boolean estallena()
{
 return(indice==tope);
}
public void insertar(int elemento)
{
    if(estaVacia())
       elemento=dato[indice++];
    else System.out.println("La pila esta llena");
}
public int obtener()
{
        if(estallena())
            return (dato[indice--]);
        else
            return 1;
}

}

