package Modelo;

import java.util.ArrayList;

public class Grilla
{
    private boolean[][] matriz;
    private int col, filas;
    private ArrayList<Palabra> palabras = new ArrayList<Palabra>();
    
    public Grilla(int col, int filas)
    {
        this.col = col;
        this.filas = filas;
        matriz = new boolean[filas][col];
    }
    
    public void addPalabra(Palabra palabra)
    {
        this.palabras.add(palabra);
    }
    
    public void removePalabra(Palabra palabra)
    {
        this.palabras.remove(palabra);
    }
    
    public void setCeldaTrue(int i, int j)
    {
        this.matriz[i][j] = true;
    }
    
    public void buscaPalabras()
    {
        buscaPalabrasHorizontal();
    }
    
    public void buscaPalabrasHorizontal(){
        
    }
}
