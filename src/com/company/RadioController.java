package com.company;

public class RadioController implements Radio {
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

    @Override
    public boolean getFrequency() {
        return false;
    }

    @Override
    public void switchAMFM() {

    }
}
