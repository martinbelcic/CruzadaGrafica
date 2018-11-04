package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Serializador
{
    private Grilla grilla;
    public static String ruta = "./prolog.pl";
    private File archivo;
    
    public Serializador(Grilla grilla)
    {
        this.grilla = grilla;
    }
    
    public void crearArchivo(){
        this.archivo = new File(ruta);
        if(this.archivo.exists()){
            this.archivo.delete();
            this.archivo = new File(ruta);
        }
    }
    
    public void escribirArchivo() throws ErrorInterseccionException {
        try {
            FileWriter fw = new FileWriter(this.archivo);
            fw.write(this.armaEstaticos());
            fw.write(this.grilla.getPalabrasTamaño());
            fw.write(this.grilla.getMiembros());
            fw.write(this.grilla.getPosiciones());
            fw.write(this.armaSolucion());
        } catch (IOException e) {
        }
    }
    
    private String armaEstaticos()
    {
        String respuesta = "longitud([],0).\n" + 
        "longitud(Lista,N):-\n" + 
        "    Lista = [_|Col],\n" + 
        "    longitud(Col,M),\n" + 
        "    N is M+1.\n" + 
        "\n" + 
        "posicion([Cabeza|_],1,Cabeza).\n" + 
        "\n" + 
        "posicion([_|Cola],N,X):-\n" + 
        "    N>0,\n" + 
        "    N1 is N-1,\n" + 
        "    posicion(Cola,N1,X1),\n" + 
        "    X=X1.\n";
        return respuesta;
    }

    private String armaSolucion() throws ErrorInterseccionException {
        String retorno = "sol(C):-\n";
        try {
            retorno += this.grilla.prologGratis();
        } catch (NoHayGratisException e) {
        }
        retorno += this.grilla.getPrologPalabras();
        retorno += this.grilla.armaPrologIntersecciones();
        return retorno;
    }
}
