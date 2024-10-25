package racingcar.model;

import java.util.ArrayList;
import racingcar.utils.RandomUtils;

public class Game {
    private final ArrayList<Car> racingCarArray;
    private final RandomUtils randomUtils = new RandomUtils();

    public Game(String[] nameArray) {
        racingCarArray = new ArrayList<>();
        for (String name : nameArray) {
            racingCarArray.add(new Car(name));
        }
    }

    public ArrayList<Car> getRacingCarArray() {
        return racingCarArray;
    }

    public void play() {
        for (Car racingCar : racingCarArray) {
            racingCar.addDistance(randomUtils.isProbabilityHit(9, 4));
        }
    }
}
