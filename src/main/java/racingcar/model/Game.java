package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<RacingCar> racingCars;

    public Game(String carNames) {
        this.racingCars = new ArrayList<>();

        String[] names = carNames.split(",");
        for (String name : names) {
            addCar(name);
        }
    }

    private void addCar(String name) {
        racingCars.add(new RacingCar(name));
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
