package com.company;

public class RadioController implements Radio {
    private boolean onOff = false;  // indica el estado del radio true-> encendido, false-> apagado
    private boolean frequency = false; // indica la frecuencia del radio true->am false->fm
    private double[] favStationAM = new double[12]; // donde se guardan las estaciones favoritas del usuario AM
    private double[] favStationFM = new double[12]; // donde se guardan las estaciones favoritas del usuario FM
    private double[] stationsAM; // donde se guardaran todas las estaciones de radio de la frecuencia AM
    private double[] stationsFM; // donde se guardaran todas las estaciones de radio de la frecuencia FM
    private double currentStation; // donde se almacena la estación actual
    

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
    public void nextStation(boolean station) {

    }

    /**
     * @author Mariel Guamuche 
    */
    @Override
    public void prevStation(boolean station) {

    }

    /**
     * @author Joshua Chicoj 
    */
    @Override
    public double getStation() {
        return this.currentStation();
    }

    /**
     * @author Joshua Chicoj 
    */
    @Override
    public void saveStation(int position, double station) {
        if (station == true) {
            favStationAM[position] = this.getStation();
        } else {
            favStationFM[position] = this.getStation();
        }
    }

    /**
     * @author Joshua Chicoj 
    */
    @Override
    public double getSavedStation(int position) {
        if (station == true) {
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
        return false;
    }

    /**
     * @author Mariel Guamuche 
    */
    @Override
    public void switchAMFM() {

    }
}
