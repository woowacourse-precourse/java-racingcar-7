package racingcar;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int totalRaceRound;

    RacingGame(final List<String> carNames, final int totalRaceRound) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
        this.totalRaceRound = totalRaceRound;
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int round = 0; round < totalRaceRound; round++) {
            cars.forEach(Car::move);
            OutputHandler.printRoundResult(cars);
        }
        OutputHandler.printFinalResult(cars);
    }
}
