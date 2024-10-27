package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.model.MovementRecord;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class IOService {

    private final InputValidator inputValidator;

    public IOService() {
        this.inputValidator = new InputValidator();
    }

    public List<String> readCarNames() {
        String carNamesInput = InputView.readCarNames();

        List<String> carNames = Arrays.stream(carNamesInput.split(","))
                .map(String::trim)
                .toList();

        inputValidator.validateCarNames(carNames);

        return carNames;
    }

    public int readTryCount() {
        String tryCountStr = InputView.readTryCount();
        inputValidator.validateTryCount(tryCountStr);

        return Integer.parseInt(tryCountStr);
    }

    public void printProcess(MovementRecord movementRecord) {
        OutputView.printProcess(movementRecord);
    }

    public void printWinners(List<String> winners) {
        OutputView.printWinners(winners);
    }

}
