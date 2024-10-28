package racingcar.Controller;

import java.util.List;
import racingcar.Constants.ViewMessage;
import racingcar.Model.Car;
import racingcar.Model.InputParser;
import racingcar.Model.MessageFormatter;
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
        List<Car> cars = readCars();
        int rounds = readRounds();
        race = new Race(cars, rounds);
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
        outputView.printMessage(ViewMessage.RESULT_MESSAGE);
        for (int i = 0; i < race.getRound(); i++) {
            race.play();

            List<String> roundResultFormat = MessageFormatter.carStates(race.getCarList());
            outputView.printMessages(roundResultFormat);
        }
    }

    private void finish() {
        List<Car> winnerList = race.getWinners();
        String winnerFormat = MessageFormatter.winners(winnerList);
        outputView.printMessage(winnerFormat);
    }

}
