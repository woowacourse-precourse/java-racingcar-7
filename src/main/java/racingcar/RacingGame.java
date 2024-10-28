package racingcar;

import java.util.List;

public record RacingGame(List<Car> cars, int rounds) {
    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRoundResults();
        }
    }

    private void printRoundResults() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
