package model;

import java.util.List;

public class RacingCar {
    private String name;
    private long distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public static List<RacingCar> createRacingCars(List<String> names) {
        return names.stream()
                .map(RacingCar::new)
                .toList();
    }
}
