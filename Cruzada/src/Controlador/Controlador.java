package Controlador;

import Vista.InterfaceDimensiones;
import Vista.InterfacePalabras;
import Vista.InterfaceValidos;
import Vista.VentanaDimensiones;

import Vista.VentanaGratis;

import Vista.VentanaPalabras;

import Vista.VentanaSolucion;

import Vista.VentanaValidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Controlador implements ActionListener
{    
    private InterfaceDimensiones dimensiones;
    private InterfacePalabras palabras;
    private InterfaceValidos validos;
    
    public Controlador(InterfaceDimensiones dimensiones)
    {
        super();
        this.dimensiones = dimensiones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equalsIgnoreCase(InterfaceDimensiones.ACEPTAR)){
            int alto = Integer.parseInt(dimensiones.getAlto());
            int ancho = Integer.parseInt(dimensiones.getAncho());
            validos = new VentanaValidos(alto, ancho);
            validos.setControlador(this);
            dimensiones.matar();
            validos.arrancar();            
        }
    }
}
