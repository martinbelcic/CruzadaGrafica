package Vista;

import Controlador.Controlador;

public interface InterfaceValidos {
    void setControlador(Controlador controlador);
    void arrancar();
    void matar();
    final static String ACEPTAR = "AceptarVal";
}
