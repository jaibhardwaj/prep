package dev.jaib.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: WeatherData.registerObserver");
    }

    @Override
    public void removeObserver(Observer o) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: WeatherData.removeObserver");
    }

    @Override
    public void notifyObservers() {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: WeatherData.notifyObservers");
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: WeatherData.setMeasurements");
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
