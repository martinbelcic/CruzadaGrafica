package Controlador;

import Modelo.Grilla;

import Vista.InterfaceDimensiones;
import Vista.InterfaceGratis;
import Vista.InterfacePalabras;
import Vista.InterfaceValidos;
import Vista.VentanaDimensiones;

import Vista.VentanaGratis;

import Vista.VentanaPalabras;

import Vista.VentanaSolucion;

import Vista.VentanaValidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Controlador implements ActionListener
{    
    private InterfaceDimensiones dimensiones;
    private InterfacePalabras palabras;
    private InterfaceValidos validos;
    private InterfaceGratis gratis;
    private Grilla grilla;
    
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
            grilla = new Grilla(ancho, alto);
            validos.setControlador(this);
            dimensiones.matar();
            validos.arrancar();            
        }
        else if(e.getActionCommand().equalsIgnoreCase(InterfaceValidos.ACEPTAR))
        {
            palabras = new VentanaPalabras();
            palabras.setControlador(this);
            //Guardar valores de la grilla
            this.setearMatriz(validos.getListaCheck());            
            validos.matar();   
            palabras.arrancar();
        }
        else if(e.getActionCommand().equalsIgnoreCase(InterfacePalabras.AGREGAR))
        {
            String palabra = palabras.getPalabra();
            grilla.addPalabraLista(palabra);
            System.out.println("Palabra agregada Correctamente: "+palabra);
            palabras.limpiar();
        }
        else if(e.getActionCommand().equalsIgnoreCase(InterfacePalabras.ACEPTAR)){
            gratis = new VentanaGratis();
            palabras.matar();
            gratis.arrancar();
        }
    }
    
    private void setearMatriz(ArrayList<JCheckBox> lista){
        int i = 0, j = 0;
        Iterator<JCheckBox> it = lista.iterator();
        while(it.hasNext()){
            JCheckBox actual = it.next();
            if(actual.isSelected()){
                this.grilla.setCeldaTrue(i, j);
            }
            if(j < (this.grilla.getCol() - 1)){
                j++;
            }
            else {
                j = 0;
                i++;
            }
        }
    }
}
