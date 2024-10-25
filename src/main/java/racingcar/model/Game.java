package racingcar.model;

import java.util.ArrayList;

public class Game {
    private int round;

    private ArrayList<Car> racingCar;

    Game(String[] nameArray) {
        round = 0;
        racingCar = new ArrayList<>();
        for (String name : nameArray) {
            racingCar.add(new Car(name));
        }
    }
}
