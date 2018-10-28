package Modelo;

public class Serializador
{
    private Grilla grilla;
    
    public Serializador(Grilla grilla)
    {
        this.grilla = grilla;
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
}
