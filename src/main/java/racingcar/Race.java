package racingcar;

import racingcar.domain.Car;
import racingcar.util.Container;
import racingcar.view.RacingCarView;
import racingcar.view.OutputView;

import java.util.List;

public class Race {
    private static final OutputView outputView = Container.getInstance(OutputView.class);
    private static final RacingCarView racingCarView = Container.getInstance(RacingCarView.class);

    private static int roundNum;
    private static List<Car> racingCars;
    private static List<String> winners;

    public static void setRacingCars() {
        try {
            set();
            play();
            showWinner();
        } catch (Exception e) {
            outputView.printErrorMessage(e);
            throw e;
        }
    }

    private static void set() {
        outputView.printStartMessage();
        racingCars = racingCarView.setCarNames();

        outputView.printRoundMessage();
        roundNum = racingCarView.setRound();
    }

    private static void play() {
        outputView.printResultMessage();
        winners = racingCarView.startRace(racingCars, roundNum);
    }

    private static void showWinner() {
        outputView.printWinnerMessage(winners);
    }
}