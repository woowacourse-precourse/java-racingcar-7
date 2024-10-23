package racingcar.infrastructure.config;

import racingcar.adapters.input.CliInputAdapter;
import racingcar.adapters.output.CliOutputAdapter;
import racingcar.application.validation.InputValidator;
import racingcar.port.input.InputPort;
import racingcar.port.output.OutputPort;

public class AppConfig {

    private final InputPort inputPort;
    private final OutputPort outputPort;
    private final InputValidator inputValidator;

    public AppConfig() {
        this.outputPort = new CliOutputAdapter();
        this.inputValidator = new InputValidator();
        this.inputPort = new CliInputAdapter(outputPort, inputValidator);
    }

    public InputPort getInputPort() {
        return inputPort;
    }
}
