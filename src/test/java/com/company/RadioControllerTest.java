package com.company;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class RadioControllerTest {

    Radio radio;
    @BeforeEach
    void setUp() {
        radio = new RadioController(); //realizara antes que todas las pruebas la instancia del objeto de tipo Radio
    }

    @org.junit.jupiter.api.Test
    void isOnTest() {
        
    }

    @org.junit.jupiter.api.Test
    void turnOnOffTest() {
    }

    @org.junit.jupiter.api.Test
    void nextStationTest() {        
    }

    @org.junit.jupiter.api.Test
    void prevStationTest() {
        radio.prevStation(radio.getFrequency());
        radio.prevStation(radio.getFrequency());
        assertEquals(107.7, Math.round(radio.getStation()*100)/100d);
    }

    @org.junit.jupiter.api.Test
    void getStationTest() {
        assertAll(() -> assertEquals(87.9, radio.getStation()),
                () -> {
                    radio.switchAMFM();
                    assertEquals(530, radio.getStation());
                });
    }

    @org.junit.jupiter.api.Test
    void saveStationTest() {
        radio.saveStation(1, 87.9);
        assertEquals(87.9, radio.getSavedStation(1));
    }

    @org.junit.jupiter.api.Test
    void getSavedStationTest() {
        assertAll(
                () -> assertEquals(radio.getSavedStation(1), 0),
                () -> {
                    radio.saveStation(2, 87.9);
                    assertEquals(87.9, radio.getSavedStation(2));
                }
        );
    }

    @org.junit.jupiter.api.Test
    void getFrequencyTest() {
        assertEquals(false, radio.getFrequency());
    }

    @org.junit.jupiter.api.Test
    void switchAMFMTest() {                
        radio.switchAMFM(); // se cambia el estado inicial de la radio (FM-> false) a AM (true)
        assertEquals(true, radio.getFrequency());
        radio.switchAMFM(); // AM (true) a FM (false.)
        assertEquals(false, radio.getFrequency());       
    }
}