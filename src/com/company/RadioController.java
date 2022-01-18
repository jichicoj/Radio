package com.company;

public class RadioController implements Radio {
    private boolean onOff; // indica el estado del radio true-> encendido, false-> apagado
    private boolean frequency; // indica la frecuencia del radio true->am false->fm
    private double[] favStationAM; // donde se guardan las estaciones favoritas del usuario AM
    private double[] favStationFM; // donde se guardan las estaciones favoritas del usuario FM
    private double[] stationsAM; // donde se guardaran todas las estaciones de radio de la frecuencia AM
    private double[] stationsFM; // donde se guardaran todas las estaciones de radio de la frecuencia FM
    private double currentStation; // donde se almacena la estación actual

    public RadioController() {
        this.onOff = false;
        this.frequency = false;
        this.currentStation = 0;
        this.favStationAM = new double[12];
        this.favStationFM  = new double[12];
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
        return false;
    }

    /**
     * @author Mariel Guamuche 
    */
    @Override
    public void switchAMFM() {

    }
}
