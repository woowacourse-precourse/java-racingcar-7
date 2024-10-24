package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.InputValidator;
import racingcar.model.CarRace;
import racingcar.view.ConsoleView;

public class RaceController {

    private CarRace carRace;
    private final ConsoleView view;

    // 의존성 주입
    public RaceController(ConsoleView view) {
        this.view = view;
    }

    public void startRace() {

        String carNamesInput = view.requestCarNames();

        InputValidator.validateEmptyInput(carNamesInput);
        InputValidator.validateCommaSeparator(carNamesInput);

        // 자동차 이름을 갖는 list 생성
        List<String> carNames = Arrays.stream(carNamesInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        InputValidator.validateSameCarName(carNames);

        String numberOfAttempts = view.requestNumberOfAttempts();
        InputValidator.validateNumber(numberOfAttempts);

        carRace = new CarRace(carNames);

        runRace(numberOfAttempts);

        displayWinners();
    }

    public void runRace(String numberOfAttempts) {
        int repeat = Integer.parseInt(numberOfAttempts);
        for (int i = 0; i < repeat; i++) {
            carRace.race();
            view.displayRaceStatus(carRace.getCars());
        }
    }

    public void displayWinners() {
        List<String> winners = carRace.findWinners();
        view.displayRaceResult(winners);
    }

}
