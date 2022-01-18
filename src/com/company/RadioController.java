package com.company;

public class RadioController implements Radio {
    private boolean onOff = false;  // indica el estado del radio true-> encendido, false-> apagado
    private boolean frequency = false; // indica la frecuencia del radio true->am false->fm
    private double[] favStationAM = new double[12]; // donde se guardan las estaciones favoritas del usuario AM
    private double[] favStationFM = new double[12]; // donde se guardan las estaciones favoritas del usuario FM
    private double[] stationsAM; // donde se guardaran todas las estaciones de radio de la frecuencia AM
    private double[] stationsFM; // donde se guardaran todas las estaciones de radio de la frecuencia FM
    
    @Override
    public boolean isOn() {
        return false;
    }

    @Override
    public void turnOnOff() {

    }

    @Override
    public void nextStation(boolean station) {

    }

    /**
     * @author Mariel Guamuche 
    */
    @Override
    public void prevStation(boolean station) {

    }

    @Override
    public double getStation() {
        return 0;
    }

    @Override
    public void saveStation(int position, double station) {

    }

    @Override
    public double getSavedStation(int position) {
        return 0;
    }

    /**
     * @author Mariel Guamuche 
    */
    @Override
    public boolean getFrequency() {
        return false;
    }

    /**
     * @author Mariel Guamuche 
    */
    @Override
    public void switchAMFM() {

    }
}
