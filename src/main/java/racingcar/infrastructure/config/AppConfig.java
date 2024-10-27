package racingcar.infrastructure.config;

import racingcar.adapters.input.RaceCliInputAdapter;
import racingcar.adapters.output.CliOutputAdapter;
import racingcar.application.service.RaceManagementCommand;
import racingcar.application.port.input.RaceManagementUsecase;
import racingcar.application.validation.InputValidator;
import racingcar.domain.race.service.RaceHelper;
import racingcar.application.port.output.OutputPort;

public class AppConfig {

    private RaceCliInputAdapter raceCliInputAdapter;
    private OutputPort outputPort;
    private InputValidator inputValidator;
    private RaceManagementUsecase raceManagementUsecase;
    private RaceHelper raceHelper;

    public RaceCliInputAdapter getRaceCliInputAdapter() {
        if (raceCliInputAdapter == null) {
            raceCliInputAdapter = new RaceCliInputAdapter(getOutputPort(), getInputValidator(), getRaceManagementUsecase());
        }
        return raceCliInputAdapter;
    }

    private OutputPort getOutputPort() {
        if (outputPort == null) {
            outputPort = new CliOutputAdapter();
        }
        return outputPort;
    }

    private InputValidator getInputValidator() {
        if (inputValidator == null) {
            inputValidator = new InputValidator();
        }
        return inputValidator;
    }

    private RaceManagementUsecase getRaceManagementUsecase() {
        if (raceManagementUsecase == null) {
            raceManagementUsecase = new RaceManagementCommand(getRaceHelper());
        }
        return raceManagementUsecase;
    }

    private RaceHelper getRaceHelper() {
        if (raceHelper == null) {
            raceHelper = new RaceHelper();
        }
        return raceHelper;
    }
}
