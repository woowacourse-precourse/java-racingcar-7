package racingcar.controller;

import racingcar.controller.validation.InputValidator;
import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.model.InputParser;
import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller { // TODO: 이름 더 명확하게 개선
    private final InputParser inputParser; // TODO: final??
    private final InputValidator<List<String>> nameValidator;
    private final InputValidator<String> attemptNumberValidator;
    private final Service service;

    public Controller(InputParser inputParser, InputValidator<List<String>> nameValidator, InputValidator<String> attemptNumberValidator, Service service) {
        this.inputParser = inputParser;
        this.nameValidator = nameValidator;
        this.attemptNumberValidator = attemptNumberValidator;
        this.service = service;
    }

    public void run() {
        // TODO: 메서드 추출
        OutputView.printCarNames();
        String initialNames = InputView.enter();
        List<String> names = inputParser.parseName(initialNames);
        nameValidator.validate(names);

        OutputView.printAttemptCount();
        String initialAttempt = InputView.enter();
        int attepmt = attemptNumberValidator.validate(initialAttempt);

        OutputView.printResultMessage();
        service.operate(names, attepmt);

        List<Car> winners =service.getWinner();
        OutputView.printWinner(winners);
    }
}