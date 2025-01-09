package racingcar;

import java.util.List;

public class Racing {

    private final Cars cars;
    private final int attemptCount;

    public Racing(List<Car> cars, int attemptCount) {
        this.cars = new Cars(cars);
        this.attemptCount = attemptCount;
    }

    public void printAllRacingResult() {
        System.out.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            cars.playRacing();
            cars.printRacingResult();
            System.out.println();
        }
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

}
