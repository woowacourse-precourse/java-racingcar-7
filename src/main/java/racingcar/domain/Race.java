package racingcar.domain;

import racingcar.domain.Car;
import racingcar.domain.CarMover;
import racingcar.domain.WinnerCalculator;
import racingcar.view.Output;

import java.util.List;

public class Race {
    private final List<Car> racingCarList;
    private final int attemptNumber;
    private final Output output;

    public Race(List<Car> racingCarList, int attemptNumber, Output output) {
        this.racingCarList = racingCarList;
        this.attemptNumber = attemptNumber;
        this.output = output;
    }

    public void start() {
        for (int i = 0; i < attemptNumber; i++) {
            CarMover.decideMoveOrNot(racingCarList);
            printResult(i);
        }
    }

    private void printResult(int attemptIndex) {
        output.printRace(racingCarList);
        if (attemptIndex == attemptNumber - 1) {
            // 마지막 레이스가 끝난 후 우승자 결과 출력
            WinnerCalculator winnerCalculator = new WinnerCalculator(racingCarList);
            output.printWinners(winnerCalculator.getWinner());
        }
    }
}