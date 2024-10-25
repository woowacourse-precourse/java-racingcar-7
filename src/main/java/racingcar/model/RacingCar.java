package racingcar.model;

public class RacingCar {

    private final Name name;
    private final Location currentLocation;

    public RacingCar(Name name, Location currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }
}