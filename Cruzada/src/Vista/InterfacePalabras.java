package Vista;

import Controlador.Controlador;

public interface InterfacePalabras {
    void setControlador(Controlador controlador);
    public String getPalabra();
    
    final static String ACEPTAR = "AceptarPal";
    final static String AGREGAR = "AgregarPal";
}
