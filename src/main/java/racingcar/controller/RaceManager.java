package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.domain.Cars;
import racingcar.view.console.ConsoleWriter;

public class RaceManager {

    private final InputView inputView;
    private static final String PLAY_START_MESSAGE = "실행 결과";
    private static final String RESULT_MESSAGE = "최종 우승자 : %s";

    public RaceManager() {
        inputView = new InputView();
    }

    public void execute() {
        Cars cars = new Cars(inputView.requestCarsName());
        int totalRounds = inputView.requestTotalRounds();

        play(cars, totalRounds);

        finish(cars);
    }

    private void play(Cars cars, int totalRounds) {
        ConsoleWriter.printlnMessage(PLAY_START_MESSAGE);

        for (int round = 1; round <= totalRounds; round++) {
            cars.playSingleRound();

            //해당 차수 실행 결과를 출력
            ConsoleWriter.printlnMessage(cars.toString());
        }
    }

    private void finish(Cars cars) {
        List<String> winnerNames = cars.getFrontCarNames();

        ConsoleWriter.printlnMessage(String.format(RESULT_MESSAGE, String.join(", ", winnerNames)));
    }

}
