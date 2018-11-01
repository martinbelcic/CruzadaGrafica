package Modelo;

public class Palabra
{
    /**
     * si el tipo es vertical, la ubicacion te da la columna, si es horizontal, te da la fila.
     */
    private int inicio, fin, ubicacion, size;
    private String tipo, palabra;
    
    public Palabra(int ini, int fin, int ubicacion, String tipo)
    {
        this.inicio = ini;
        this.fin = fin;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.size = fin - inicio;
    }

    public void setPalabra(String palabra)
    {
        this.palabra = palabra;
    }

    public String getPalabra()
    {
        return palabra;
    }
    
    public int getSize(){
        return this.size;
    }
}
