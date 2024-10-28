package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class Game {
    private final List<Car> racingCarList;
    private final RandomUtils randomUtils;

    public Game(List<String> nameList) {
        this.randomUtils = new RandomUtils();
        racingCarList = nameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getRacingCarArray() {
        return racingCarList;
    }

    public void play() {
        for (Car racingCar : racingCarList) {
            moveCarIfHit(racingCar);
        }
    }

    private void moveCarIfHit(Car car) {
        car.addDistance(randomUtils.isProbabilityHit(9, 4));
    }
}
