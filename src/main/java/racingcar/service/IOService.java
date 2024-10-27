package racingcar.service;

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
        String carNamesInput = InputView.readCarName();
        String[] carNames = carNamesInput.split(",");

        for (String name : carNames) {
            inputValidator.validateCarName(name.trim());
        }

        return List.of(carNames);
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
