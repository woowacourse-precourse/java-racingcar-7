package racingcar.infrastructure.config;

import racingcar.adapters.input.RaceCliInputAdapter;
import racingcar.adapters.output.CliOutputAdapter;
import racingcar.application.service.ManageRaceCommand;
import racingcar.application.port.input.ManageRaceUsecase;
import racingcar.application.validation.InputValidator;
import racingcar.domain.race.service.RaceHelper;
import racingcar.application.port.output.OutputPort;

public class AppConfig {

    private RaceCliInputAdapter raceCliInputAdapter;
    private OutputPort outputPort;
    private InputValidator inputValidator;
    private ManageRaceUsecase manageRaceUsecase;
    private RaceHelper raceHelper;

    public RaceCliInputAdapter getRaceCliInputAdapter() {
        if (raceCliInputAdapter == null) {
            raceCliInputAdapter = new RaceCliInputAdapter(getOutputPort(), getInputValidator(), getManageRaceUsecase());
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

    private ManageRaceUsecase getManageRaceUsecase() {
        if (manageRaceUsecase == null) {
            manageRaceUsecase = new ManageRaceCommand(getRaceHelper());
        }
        return manageRaceUsecase;
    }

    private RaceHelper getRaceHelper() {
        if (raceHelper == null) {
            raceHelper = new RaceHelper();
        }
        return raceHelper;
    }
}
