/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalcalcu;

/**
 *
 * @author arturo88
 */
public class Pila {
    private char [] dato;
    private int indice;

public Pila(int tamaño)
{
    indice=-1;
    dato=new char[tamaño];
}
public boolean isVacia()
{
    return(indice==0);
}
public boolean isLlena()
{
 return(indice==dato.length);
}
public void insertar(char elemento)
{
    if(!isLlena())
      dato[indice++] = elemento;
    else System.out.println("La pila esta llena");
}
public char obtener()
{
        if(!isVacia())
            return dato[indice--];
        else
            return ' ';
}
    public char cima()
    {
        if(!isVacia())
            return dato[indice-1];
        else
            return 1;
    }
    public int getIndice(){
        return indice;
    }
}

