package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final List<Car> cars;
    private final int tryCount;

    public RacingController(List<String> carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
    }

    public RacingController(List<Car> cars) {
        this.cars = cars;
        tryCount=0;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            playRound();
            RacingView.printRoundResult(cars);
        }
        RacingView.printWinners(findWinners());
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<String> findWinners() {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
