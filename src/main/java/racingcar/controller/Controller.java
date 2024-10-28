package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView = InputView.INSTANCE;
    private final OutputView outputView = OutputView.INSTANCE;
    public void run(){
        String input = readNames();
        Integer times = readTimes();
        outputView.printPrompt();

        Cars cars = Cars.getInstance(getRawNames(input));
        Referee referee = Referee.getInstance(cars);

        startRace(times, referee);

        String message = referee.judge();
        outputView.print(message);
    }

    private List<String> getRawNames(String input) {
        return Arrays.stream(input.split(",")).toList();
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
