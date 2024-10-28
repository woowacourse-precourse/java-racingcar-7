package racingcar.Controller;

import java.util.List;
import racingcar.Model.Car;
import racingcar.Model.InputParser;
import racingcar.Model.Race;
import racingcar.Model.Validator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        ready();
        play();
        finish();
    }

    private void ready() {
        List<Car> carList = readCars();
        int rounds = readRounds();
        race = new Race(carList, rounds);
    }

    private List<Car> readCars() {
        String input = inputView.requestCarNames();
        Validator.inputCarNames(input);

        List<Car> carList = InputParser.stringToCarList(input);
        Validator.carList(carList);

        return carList;
    }

    private int readRounds() {
        String input = inputView.requestRound();
        Validator.inputRound(input);
        int round = InputParser.stringToRound(input);
        Validator.round(round);
        return round;
    }

    private void play() {
        outputView.printResultMessage();
        for (int i = 0; i < race.getRound(); i++) {
            race.play();
            outputView.printCarStates(race.getCarList());
            System.out.println();
        }
    }

    private void finish() {
        List<Car> winnerList = race.getWinnerList();
        outputView.printResult(winnerList);
    }

}
