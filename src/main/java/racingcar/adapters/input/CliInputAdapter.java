package racingcar.adapters.input;

import static racingcar.infrastructure.constants.AnnounceMessages.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.dto.request.RaceRequest;
import racingcar.application.validation.InputValidator;
import racingcar.port.input.InputPort;
import racingcar.port.output.OutputPort;

public class CliInputAdapter implements InputPort {

    private final OutputPort outputPort;
    private final InputValidator inputValidator;

    public CliInputAdapter(OutputPort outputPort, InputValidator inputValidator) {
        this.outputPort = outputPort;
        this.inputValidator = inputValidator;
    }

    @Override
    public RaceRequest getInput() {
        String carNames = getCarNames();
        int round = getRound();
        return new RaceRequest(carNames, round);
    }

    private String getCarNames() {
        outputPort.writeMessage(INPUT_CAR_NAMES.getMessage());
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);
        return carNames;
    }

    private int getRound() {
        outputPort.writeMessage(INPUT_TRY_COUNT.getMessage());
        String tryCountInput = Console.readLine();
        inputValidator.validateRound(tryCountInput);
        return Integer.parseInt(tryCountInput);
    }

}
