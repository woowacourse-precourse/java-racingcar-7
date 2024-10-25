package racingcar.infrastructure.config;

import racingcar.adapters.input.RaceCliInputAdapter;
import racingcar.adapters.output.CliOutputAdapter;
import racingcar.application.service.RaceExecutionCommand;
import racingcar.application.usecase.RaceExecutionUseCase;
import racingcar.application.validation.InputValidator;
import racingcar.domain.race.service.RaceHelper;
import racingcar.application.port.input.RaceInputPort;
import racingcar.application.port.output.OutputPort;

public class AppConfig {

    private final RaceInputPort raceInputPort;
    private final OutputPort outputPort;
    private final InputValidator inputValidator;
    private final RaceExecutionUseCase raceUseCase;
    private final RaceHelper raceService;

    public AppConfig() {
        this.outputPort = new CliOutputAdapter();
        this.inputValidator = new InputValidator();
        this.raceService = new RaceHelper();
        this.raceUseCase = new RaceExecutionCommand(raceService);
        this.raceInputPort = new RaceCliInputAdapter(outputPort, inputValidator, raceUseCase);
    }

    public RaceInputPort getRaceInputPort() {
        return raceInputPort;
    }
}
