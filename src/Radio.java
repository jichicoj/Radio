public interface Radio {
    /**
     *
     */
    void turnOn();

    /**
     *
     */
    void turnOff();

    /**
     *
     *
     */
    boolean isOn();

    /**
     *
     */
    void nextStationAm();

    /**
     *
     */
    void prevStationAm();

    /**
     *
     */
    void nextStationFm();

    /**
     *
     */
    void prevStationFm();

    boolean changeFrequency();

    boolean getFrequency();

    /**
     *
     * @return
     */
    int getSongPosition();

    /**
     *
     * @param position
     */
    void addFavorite(int position);

    /**
     *
     * @param position
     * @return
     */
    String getFavorite(int position);

    /**
     *
     * @return
     */
    String getState();
}
