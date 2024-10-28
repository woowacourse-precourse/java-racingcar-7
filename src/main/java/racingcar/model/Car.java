package racingcar.model;

public class Car {

    private String name;
    private int currentLocation;


    public Car(String name) {
        this.name = name;
        this.currentLocation = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }

    public void increaseCurrentLocation() {
        this.currentLocation++;
    }

}
