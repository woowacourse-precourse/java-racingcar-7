package model;

import java.util.List;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static List<RacingCar> createRacingCars(List<String> names) {
        return names.stream()
                .map(RacingCar::new)
                .toList();
    }

    public void increaseDistance() {
        this.distance++;
    }
}
