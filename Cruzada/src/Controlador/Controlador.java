package Controlador;

import Vista.VentanaDimensiones;

import Vista.VentanaGratis;

import Vista.VentanaPalabras;

import Vista.VentanaSolucion;

import Vista.VentanaValidos;

import javax.swing.JFrame;

public class Controlador
{
    
    private JFrame ventDim, ventGratis, ventPalabras, ventSol, ventVal;
    
    public Controlador()
    {
        super();
        this.ventDim = new VentanaDimensiones();
        this.ventGratis = new VentanaGratis();
        this.ventPalabras = new VentanaPalabras();
        this.ventSol = new VentanaSolucion();
        this.ventVal = new VentanaValidos();
    }

    public static void main(String[] args)
    {
        Controlador c = new Controlador();
        c.ventDim.setVisible(true);
    }
}
