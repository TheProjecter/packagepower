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
    private char [] dato;
    private int tope,indice;

public Pila(int tamaño)
{
    indice=0;
    tope=tamaño-1;
    dato=new char[tamaño];
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
public char obtener()
{
        if(!estaVacia())
            return dato[--indice];
        else
            return 1;
}

}
