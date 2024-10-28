package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RaceReferee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        String carNames = getCarNames();
        List<Car> cars = createCarsFromNames(carNames);
        int round = getRacingRound();
        RaceReferee referee = RaceReferee.from(round);
        inputView.closeConsole();

        while (round > 0) {
            referee.playRound(cars);
            outputView.printMovingCarsWithPositions(cars);
            --round;
        }

        List<String> winners = referee.declareWinnerNames(cars);
        outputView.printRacingWinners(winners);
    }

    private String getCarNames() {
        outputView.printRacingCarNameFormat();
        return inputView.readCarNames();
    }

    private int getRacingRound() {
        outputView.printRacingRoundRequest();
        return inputView.readRacingRound();
    }

    private List<Car> createCarsFromNames(String names) {
        String[] splitNames = names.split(",");
        return Arrays.stream(splitNames).map(Car::from).toList();
    }
}
