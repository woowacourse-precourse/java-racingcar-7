package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private List<Car> cars;
    private int attemptCount;

    public Game(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void playRound() {

        for (Car car : cars) {

            if(Randoms.pickNumberInRange(0, 9) >= 4)
            car.advance();
        }
    }

    public String getRoundResult() {

        StringBuilder resultBuilder = new StringBuilder();

        for (Car car : cars) {

            resultBuilder.append(car.getStatus());
        }

        return resultBuilder.toString();
    }

    public List<Car> getWinners() {
        int maxMileage = cars.stream()
                            .mapToInt(Car::getMileage)
                            .max()
                            .orElse(0);

        return cars.stream()
                    .filter(car -> car.getMileage() == maxMileage)
                    .toList();
    }

    public int getAttemptCount() {
        return attemptCount;
    }

}
