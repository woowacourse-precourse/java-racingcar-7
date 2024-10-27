package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView = InputView.INSTANCE;
    private final OutputView outputView = OutputView.INSTANCE;
    public void run(){
        String names = readNames();
        Integer times = readTimes();
        outputView.printPrompt();

        Cars cars = Cars.getInstance(names);
        Referee referee = Referee.getInstance(cars);

        startRace(times, referee);

        String message = referee.judge();
        outputView.print(message);
    }

    private String readNames() {
        return inputView.readNames();
    }
    private Integer readTimes() {
        return inputView.readTime();
    }

    private void startRace(Integer times, Referee referee) {
        referee.start(times);
    }
}
