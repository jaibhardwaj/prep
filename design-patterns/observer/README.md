# Observer Design Pattern

## Intent
**Observer** is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.

## Class Diagram

```mermaid
classDiagram
    class Subject {
        <<interface>>
        +registerObserver(Observer o)
        +removeObserver(Observer o)
        +notifyObservers()
    }
    class Observer {
        <<interface>>
        +update(float temp, float humidity, float pressure)
    }
    class WeatherData {
        -List~Observer~ observers
        -float temperature
        -float humidity
        -float pressure
        +setMeasurements(float temp, float humidity, float pressure)
    }
    class CurrentConditionsDisplay {
        -float temperature
        -float humidity
        -Subject weatherData
        +display()
        +update(float temp, float humidity, float pressure)
    }
    WeatherData ..|> Subject : implements
    CurrentConditionsDisplay ..|> Observer : implements
    WeatherData --> Observer : notifies
```

## Problem Statement
We need to design a Weather Monitoring Station. The `WeatherData` object tracks the current weather measurements (temperature, humidity, pressure). We have various display elements (like `CurrentConditionsDisplay`) that need to be updated in real-time as the weather data changes.

## How to Test
Run the tests in the root folder to verify the implementation:
```bash
./gradlew :design-patterns:observer:test
```
