package com.company;

import java.util.ArrayList;

/**
 * @author Joshua Chicoj
 * @author Ximena Loarca
 * @author Mariel Guamuche
 * @since "17/enero/2022"
 */
public class RadioController implements Radio {
    private boolean onOff; // indica el estado del radio true-> encendido, false-> apagado
    private boolean frequency; // indica la frecuencia del radio true->am false->fm
    private double[] favStationAM; // donde se guardan las estaciones favoritas del usuario AM
    private double[] favStationFM; // donde se guardan las estaciones favoritas del usuario FM
    private ArrayList<Double> stationsAM; // donde se guardaran todas las estaciones de radio de la frecuencia AM
    private ArrayList<Double> stationsFM; // donde se guardaran todas las estaciones de radio de la frecuencia FM
    private double currentStation; // donde se almacena la estación actual

    /**
     * Constructor
     */
    public RadioController() {
        this.onOff = false;
        this.frequency = false;
        this.favStationAM = new double[12];
        this.favStationFM  = new double[12];
        this.stationsAM = new ArrayList<>();
        this.stationsFM = new ArrayList<>();
        setstationsAMFM();
        this.currentStation = stationsFM.get(0);
    }


    /**
     * Realiza el autollenado de las estaciones de radio disponibles. No tiene datos de retorno.
     */
    private void setstationsAMFM() {        
        double i=530.0;        
        do {
            stationsAM.add(i);
            i += 10;            
        } while(i<=1610.0);

        i=87.9;            
        do {            
            stationsFM.add(i);    
            i += 0.2;        
        } while(i<108.1);
    }
    
    /**
     * @author Ximena Loarca
     * Muestra el estado actual de la radio
     */
    @Override
    public boolean isOn() {
        return onOff;
    }

    /**
     * @author Ximena Loarca
     * Cambia el estado actual de la radio
     */
    @Override
    public void turnOnOff() {
        if (onOff == false){
            onOff = true;
        }
        else{
            onOff = false;
        }
    }

    /**
     * @author Ximena Loarca
     * Cambia a la siguiente estacion de radio
     */
    @Override
    public void nextStation(boolean frequency) {
        if(frequency==this.frequency) { 
            if(this.frequency) { 
                int posicion=0;
                for (double d : this.stationsAM) {
                    if(d==this.currentStation) { break; } 
                    posicion++; 
                }
                if(posicion== this.stationsAM.size()-1) {
                    this.currentStation=this.stationsAM.get(posicion=0);
                } else {
                    this.currentStation = this.stationsAM.get(posicion+1);
                }
            } else { 
                int posicion=0;
                for (double d : this.stationsFM) {
                    if(d==this.currentStation) { break; } 
                    posicion++;
                }
                if(posicion== this.stationsFM.size()-1) {
                    this.currentStation=this.stationsFM.get(posicion=0);
                } else {
                    this.currentStation = this.stationsFM.get(posicion+1); 
                }
            }
        }
    }


    /**
     * Cambia a la estación previa de la radio
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
                    this.currentStation = this.stationsAM.get(this.stationsAM.size() - 1); // cuando esta en la primera estacion, entonces el previo es la ultima en la lista
                } else {
                    this.currentStation = this.stationsAM.get(posicion-1); // de lo contrario muestra la estacion anterior
                }
            } else { // se debe de usar el array de estaciones FM
                int posicion=0;
                for (double d : this.stationsFM) {
                    if(d==this.currentStation) { break; } // al encontrar al valor que se igualan debe terminar el ciclo
                    posicion++;
                }
                if(posicion==0) {
                    this.currentStation=this.stationsFM.get(this.stationsFM.size() - 1);// cuando esta en la primera estacion, entonces el previo es la ultima en la lista
                } else {
                    this.currentStation = this.stationsFM.get(posicion-1); //realiza el cambio en la estacion actual
                }
            }
        }
    }

    /**
     * Devuelve la estación actual
     * @author Joshua Chicoj
     * @return
     */
    @Override
    public double getStation() {
        return this.currentStation;
    } // retorna la estacición actual

    /**
     * Guarda la estación actual en una posición dentro del arraylist de favoritos
     * @author Joshua Chicoj
     * @param position index indicating where to store the station.
     * @param station double indicating the station.
     */
    @Override
    public void saveStation(int position, double station) {
        if (this.getFrequency()) { // Verifica la estación
            favStationAM[position - 1] = station; // Almacena la estación en la posición indicada dentro del arraylist
        } else {
            favStationFM[position - 1] = station;
        }
    }

    /**
     * Obtiene la estación almacenada en una posición del arraylist de favoritos
     * @author Joshua Chicoj
     * @param position index indicating which station to pick.
     * @return
     */
    @Override
    public double getSavedStation(int position) {
        if (this.getFrequency()) { // Verifica la estación
            if (favStationAM[position - 1] != 0) { // Verifica que el valor dentro de la posición indicada esté lleno
                currentStation = favStationAM[position - 1]; // Cambia la estación actual con la estación de la posición del arraylist
            }

            return favStationAM[position - 1]; // Devuelve la estación almacenada en la posición indicada
        } else {
            if (favStationFM[position - 1] != 0) {
                currentStation = favStationFM[position - 1];
            }

            return favStationFM[position - 1];
        }
    }
  
    /**
     * Indica el estado de la frecuencia actual AM->true, FM->false
     * @author Mariel Guamuche
    */
    @Override
    public boolean getFrequency() {
        return this.frequency; //retorna el valor de la frecuencia actual
    }

    /**
     * Cambia el tipo de frecuencia AM->true, FM->false
     * Coloca por default la primera estación de radio de dicha frecuencia
     *  @author Mariel Guamuche
    */
    @Override
    public void switchAMFM() {
        if(this.frequency==true) { // valida el estado de la frecuencia
            this.frequency = false; // cambia a frecuencia FM
            this.currentStation = stationsFM.get(0);
        } else {
            this.frequency = true; // cambia a frecuencia AM
            this.currentStation = stationsAM.get(0);
        }
    }
}
