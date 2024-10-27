package racingcar.controller;

import java.math.BigInteger;
import java.util.List;
import racingcar.model.Parser;
import racingcar.model.Validator;
import racingcar.model.domain.Cars;
import racingcar.view.InputView;

public class InputController {

    private final InputView inputView;
    private final Parser parser;
    private final Validator validator;

    public InputController(InputView inputView, Parser parser, Validator validator) {
        this.inputView = inputView;
        this.parser = parser;
        this.validator = validator;
    }

    public Cars getValidatedCarNames() {
        String carNamesInput = inputView.getCarNamesInput();
        List<String> carNames = parser.parseCarNames(carNamesInput);
        validator.validateCarNames(carNames);
        return new Cars(carNames);
    }

    public BigInteger getValidatedAttemptCount() {
        String attemptCountInput = inputView.getAttemptCountInput();
        BigInteger attemptCount = parser.convertStringToBigInteger(attemptCountInput);
        validator.validateAttemptCount(attemptCount);
        return attemptCount;
    }
}
