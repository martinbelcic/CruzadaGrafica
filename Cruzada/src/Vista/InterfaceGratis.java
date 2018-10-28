package Vista;

import Controlador.Controlador;

public interface InterfaceGratis {
    void setControlador(Controlador controlador);
    void arrancar();
    void matar();
    
    public static String ACEPTAR = "AceptarGratis";
}
