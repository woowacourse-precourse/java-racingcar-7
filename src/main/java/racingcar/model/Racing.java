package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Racing {
    private final List<Car> cars;
    private final int totalRounds;
    private int currentRound;

    private Racing(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.currentRound = 0;
    }


    public void executeRound() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(1, 10) >= 4) {
                car.move();
            }
        }
        currentRound++;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public boolean hasNextRound() {
        return (currentRound < totalRounds);
    }

    public static Racing from(List<String> carNames, int totalRounds) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Racing(cars, totalRounds);
    }
}
