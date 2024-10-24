package racingcar.validator;

import java.util.List;
import racingcar.validator.strategies.CarNameValidator;
import racingcar.validator.strategies.TryCountValidator;
import racingcar.view.InputView;

public class InputValidator {

    private final CarNameValidator carNameValidator;
    private final TryCountValidator tryCountValidator;
    private final InputView inputView;

    public InputValidator(InputView inputView) {
        this.carNameValidator = new CarNameValidator();
        this.tryCountValidator = new TryCountValidator();
        this.inputView = inputView;
    }

    public List<String> getValidatedCarNames() {
        String carNamesInput = inputView.inputCarNames();
        carNameValidator.validate(carNamesInput);
        return List.of(carNamesInput.split(","));
    }

    public int getValidatedTryCount() {
        String tryCountInput = inputView.inputTryCount();
        tryCountValidator.validate(tryCountInput);
        return Integer.parseInt(tryCountInput);
    }

}
