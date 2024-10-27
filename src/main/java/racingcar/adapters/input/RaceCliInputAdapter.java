package racingcar.adapters.input;

import static racingcar.infrastructure.constants.AnnounceMessages.*;
import static racingcar.infrastructure.exception.ErrorCode.ROUND_NOT_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.application.port.input.ManageRaceUsecase;
import racingcar.application.validation.InputValidator;
import racingcar.application.port.output.OutputPort;

public class RaceCliInputAdapter {

    private final OutputPort outputPort;
    private final InputValidator inputValidator;
    private final ManageRaceUsecase manageRaceUsecase;

    public RaceCliInputAdapter(OutputPort outputPort, InputValidator inputValidator,
        ManageRaceUsecase manageRaceUsecase) {
        this.outputPort = outputPort;
        this.inputValidator = inputValidator;
        this.manageRaceUsecase = manageRaceUsecase;
    }

    public void startRace() {
        RaceRequest raceRequest = getRaceInput();
        RaceResponse raceResponse = manageRaceUsecase.run(raceRequest);
        outputPort.writeResponse(raceResponse);
    }

    private RaceRequest getRaceInput() {
        String carNames = promptCarNames();
        int round = promptRound();
        return new RaceRequest(carNames, round);
    }

    private String promptCarNames() {
        outputPort.writeMessage(INPUT_CAR_NAMES.getMessage());
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);
        return carNames;
    }

    private int promptRound() {
        outputPort.writeMessage(INPUT_TRY_COUNT.getMessage());
        String round = Console.readLine();
        inputValidator.validateRound(round);
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_NOT_NUMBER.getMessage());
        }
    }
}
