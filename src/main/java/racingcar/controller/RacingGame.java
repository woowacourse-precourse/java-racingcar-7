package racingcar.controller;

import racingcar.domain.Forward;
import racingcar.domain.ValueExtractor;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame{
    String[] cars;
    int[] forwardDistance;
    int racingCount;
    List<String> winner;

    public RacingGame(String[] cars, int racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
        forwardDistance = new int[cars.length];
        winner = new ArrayList<>();
    }

    public void play() {

        System.out.println("실행 결과");

        for (int count = 0; count < racingCount; count++) {
            Forward.move(forwardDistance);
            OutputView.printForwardResult(cars, forwardDistance);
        }

        int max = ValueExtractor.getMaxValue(forwardDistance);
        ValueExtractor.getWinner(cars, forwardDistance, winner, max);

        String result = String.join(", ", winner);
        OutputView.printResult(result);
    }
}
