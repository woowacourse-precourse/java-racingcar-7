package racingcar.model;

import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import java.util.List;

public class InputProcessor {

    public List<String> getValidatedCarNames() {
        List<String> carNames = InputView.getCarNames();
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int getValidatedRounds() {
        int rounds = InputView.getRounds();
        InputValidator.validateRounds(rounds);
        return rounds;
    }
}
