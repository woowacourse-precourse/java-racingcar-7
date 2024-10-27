package racingcar;

import java.util.List;

public class Racing {
    private final List<Car> cars;
    private final int totalAttempts;
    private final Move move;
    private final OutputView outputView;

    public Racing(List<Car> cars, int totalAttempts, Move move, OutputView outputView) {
        this.cars = cars;
        this.totalAttempts = totalAttempts;
        this.move = move;
        this.outputView = outputView;
    }

    public void race() {
        outputView.printResultPhrase();
        for (int i = 0; i < totalAttempts; i++) {
            move.tryOnce();
            outputView.printRaceResult(createCurrentCars());
        }
    }

    private List<CurrentCar> createCurrentCars() {
        return cars.stream().map(Car::createCurrentCar).toList();
    }

    public void announceWinners() {
        outputView.printWinners(createJudge().getWinnerNames());
    }

    private Judge createJudge() {
        return new Judge(createCurrentCars());
    }
}