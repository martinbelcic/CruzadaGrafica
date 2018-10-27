package Modelo;

import java.util.ArrayList;

public class Grilla
{
    private boolean[][] matriz;
    private int col, filas;
    private ArrayList<Palabra> palabras = new ArrayList<Palabra>();
    private ArrayList<Interseccion> intersecciones = new ArrayList<Interseccion>();
    
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
    
    public void addInterseccion(Interseccion interseccion){
        this.intersecciones.add(interseccion);
    }
    
    public void removePalabra(Palabra palabra)
    {
        this.palabras.remove(palabra);
    }
    
    public void setCeldaTrue(int i, int j)
    {
        this.matriz[i][j] = true;
    }
    
    public boolean getCelda(int i, int j){
        return this.matriz[i][j];
    }
    
    public void buscaPalabras()
    {
        buscaPalabrasHorizontal();
    }
    
    public void buscaPalabrasHorizontal(){
        for(int i = 0; i < this.filas; i++){
            for(int j = 0; j < this.col; j++){
                if(this.getCelda(i, j)){
                    int inicio = j, fin = j;
                    while(this.getCelda(i, j)){
                        fin = j;
                        j++;
                    }
                    this.addPalabra(new Palabra(inicio, fin, i, "horizontal"));
                }
            }
        }
    }
    
    public void buscaPalabrasVertical(){
        for(int j = 0; j < this.filas; j++){
            for(int i = 0; i < this.col; i++){
                if(this.getCelda(i, j)){
                    int inicio = i, fin = i;
                    while(this.getCelda(i, j)){
                        fin = i;
                        i++;
                    }
                    this.addPalabra(new Palabra(inicio, fin, j, "vertical"));
                }
            }
        }
    }
    
    public void buscaInterseccion(){
        for(int i = 0; i < this.filas; i++){
            for(int j = 0; j < this.col; j++){
                if(hayInterseccion(i,j)){
                    this.addInterseccion(new Interseccion(i,j));
                }
            }
        }
    }
    
    public boolean hayInterseccion(int i, int j){
        boolean respuesta, left, right, up, down;
        respuesta = this.getCelda(i, j);
        //comprobar que las celdas que toca cumplan.
        up = (i > 0) && this.getCelda(i-1, j);
        down = (i < this.filas - 1) && this.getCelda(i+1, j); 
        left = (j > 0) && this.getCelda(i, j-1);
        right = (j < this.col - 1) && this.getCelda(i, j+1); 
        //todas las condiciones de interseccion
        return respuesta && ((up && right) || (right && down) || (down && left) || (left && up));
    }
}
