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
        List<Car> cars = readCars();
        int rounds = readRounds();
        race = new Race(cars, rounds);
    }

    private List<Car> readCars() {
        String input = inputView.requestCarNames();
        Validator.inputSting(input);
        return InputParser.stringToCarList(input);
    }

    private int readRounds() {
        String input = inputView.requestRound();
        Validator.checkRound(input);
        return InputParser.stringToRound(input);
    }

    private void play() {

        for (int i = 0; i < race.getRound(); i++) {
            race.play();
            outputView.printCarStates(race.getCarList());
        }
    }

    private void finish() {
       List<Car> winnerList =  race.getWinnerList();
       outputView.printResult(winnerList);
    }

}
