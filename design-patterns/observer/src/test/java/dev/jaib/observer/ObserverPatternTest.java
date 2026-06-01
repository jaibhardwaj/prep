package dev.jaib.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverPatternTest {

    @Test
    public void testObserverNotification() {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80.0f, 65.0f, 30.4f);
        assertEquals(80.0f, display.getTemperature());
        assertEquals(65.0f, display.getHumidity());

        weatherData.setMeasurements(82.2f, 70.0f, 29.2f);
        assertEquals(82.2f, display.getTemperature());
        assertEquals(70.0f, display.getHumidity());
    }

    @Test
    public void testRemoveObserver() {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80.0f, 65.0f, 30.4f);
        assertEquals(80.0f, display.getTemperature());

        weatherData.removeObserver(display);
        weatherData.setMeasurements(90.0f, 75.0f, 30.4f);
        
        // Temperature of display should remain 80.0f since it is removed
        assertEquals(80.0f, display.getTemperature());
    }
}
