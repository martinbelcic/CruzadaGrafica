package Vista;

import Controlador.Controlador;

public interface InterfaceDimensiones {
    void setControlador(Controlador controlador);
    public String getAlto();
    public String getAncho();
    public void matar();
    final static String ACEPTAR = "AceptarDim";
}
