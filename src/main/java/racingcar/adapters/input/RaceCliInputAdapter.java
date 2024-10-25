package racingcar.adapters.input;

import static racingcar.infrastructure.constants.AnnounceMessages.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.application.usecase.RaceExecutionUseCase;
import racingcar.application.validation.InputValidator;
import racingcar.application.port.input.RaceInputPort;
import racingcar.application.port.output.OutputPort;

public class RaceCliInputAdapter implements RaceInputPort {

    private final OutputPort outputPort;
    private final InputValidator inputValidator;
    private final RaceExecutionUseCase raceExecutionUseCase;

    public RaceCliInputAdapter(OutputPort outputPort, InputValidator inputValidator,
        RaceExecutionUseCase raceExecutionUseCase) {
        this.outputPort = outputPort;
        this.inputValidator = inputValidator;
        this.raceExecutionUseCase = raceExecutionUseCase;
    }

    @Override
    public void initialRace() {
        RaceRequest raceRequest = getInput();
        RaceResponse raceResponse = raceExecutionUseCase.runRace(raceRequest);
        outputPort.writeResponse(raceResponse);
    }

    public RaceRequest getInput() {
        return new RaceRequest(getCarNames(), getRound());
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
