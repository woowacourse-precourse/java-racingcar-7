package racingcar;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    GameController() {
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
        Validator.inputSting(input);

        List<Car> carList = InputParser.stringToCarList(input);
        Validator.carList(carList);

        return carList;
    }

    private int readRounds() {
        String input = inputView.requestRound();
        Validator.round(input);
        return InputParser.stringToRound(input);
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
