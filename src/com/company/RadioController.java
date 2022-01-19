package com.company;

import java.util.ArrayList;

public class RadioController implements Radio {
    private boolean onOff; // indica el estado del radio true-> encendido, false-> apagado
    private boolean frequency; // indica la frecuencia del radio true->am false->fm
    private double[] favStationAM; // donde se guardan las estaciones favoritas del usuario AM
    private double[] favStationFM; // donde se guardan las estaciones favoritas del usuario FM
    private ArrayList<Double> stationsAM; // donde se guardaran todas las estaciones de radio de la frecuencia AM
    private ArrayList<Double> stationsFM; // donde se guardaran todas las estaciones de radio de la frecuencia FM
    private double currentStation; // donde se almacena la estación actual

    public RadioController() {
        this.onOff = false;
        this.frequency = false;
        this.currentStation = 0;
        this.favStationAM = new double[12];
        this.favStationFM  = new double[12];
        this.stationsAM = new ArrayList<>();
        this.stationsFM = new ArrayList<>();
        setstationsAMFM();
    }

    /**
     * @author Ximena Loarca
     */
    @Override
    public boolean isOn() {
        return false;
    }

    /**
     * @author Ximena Loarca
     */
    @Override
    public void turnOnOff() {

    }

    /**
     * @author Ximena Loarca
     */
    @Override
    public void nextStation(boolean frequency) {

    }


    /**
     * @author Mariel Guamuche 
    */
    @Override
    public void prevStation(boolean frequency) {      
        if(frequency==this.frequency) { // valida que sean las mismas frecuencias de radio0
            if(this.frequency == true) { // se debe de usar el array de estaciones AM
                int posicion=0;
                for (double d : this.stationsAM) {
                    if(d==this.currentStation) { break; } 
                    posicion++; // mientras no encuentre la posicion de la estacion actual, entonces sumara a la siguiente posicion 
                }
                if(posicion==0) {
                    System.out.println(this.stationsAM.get(this.stationsAM.size())); // cuando esta en la primera estacion, entonces el previo es la ultima en la lista
                } else {
                    System.out.println(this.stationsAM.get(posicion-1)); // de lo contrario muestra la estacion anterior 
                }
            } else { // se debe de usar el array de estaciones FM
                int posicion=0;
                for (double d : this.stationsFM) {
                    if(d==this.currentStation) { break; } // al encontrar al valor que se igualan debe terminar el ciclo
                    posicion++;
                }
                if(posicion==0) {
                    this.currentStation=this.stationsFM.get(this.stationsFM.size());
                    System.out.println(this.currentStation); // cuando esta en la primera estacion, entonces el previo es la ultima en la lista
                } else {
                    this.currentStation = this.stationsFM.get(posicion-1); //realiza el cambio en la estacion actual
                    System.out.println(this.currentStation); // de lo contrario muestra la estacion anterior 
                }
            }
        }
    }

    /**
     * Realiza el autollenado de las estaciones de radio disponibles.
     */
    private void setstationsAMFM() {        
        double i=530.0;
        stationsAM.add(i); // se agrega la primera radio
        do {
            stationsAM.add(i+10);
        } while(i<=1610.0);

        i=87.9;
        stationsFM.add(i); // se agrega la primera radio
        do {
            stationsFM.add(i+0.2);
        } while(i<=107.9);
    }

    /**
     * @author Joshua Chicoj 
    */
    @Override
    public double getStation() {
        return this.currentStation;
    }

    /**
     * @author Joshua Chicoj 
    */
    @Override
    public void saveStation(int position, double station) {
        if (this.getFrequency()) {
            favStationAM[position] = station;
        } else {
            favStationFM[position] = station;
        }
    }

    /**
     * @author Joshua Chicoj 
    */
    @Override
    public double getSavedStation(int position) {
        if (this.getFrequency()) {
            return favStationAM[position];
        } else {
            return favStationFM[position];
        }
    }
    /**
     * @author Mariel Guamuche 
    */
    @Override
    public boolean getFrequency() {
        return this.frequency; //retorna el valor de la frecuencia actual
    }

    /**
     * @author Mariel Guamuche 
    */
    @Override
    public void switchAMFM() {
        if(this.frequency==true) { // valida el estado de la frecuencia
            this.frequency = false; // cambia a frecuencia FM
        } else {
            this.frequency = true; // cambia a frecuencia AM
        }
    }
}
