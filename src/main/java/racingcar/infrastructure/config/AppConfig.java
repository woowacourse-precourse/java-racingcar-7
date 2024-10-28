package racingcar.infrastructure.config;

import racingcar.adapter.inbound.cli.InputAdapter;
import racingcar.adapter.outbound.cli.OutputAdapter;
import racingcar.application.port.inbound.GameUseCase;
import racingcar.adapter.inbound.InboundAdapter;
import racingcar.application.port.inbound.InputPort;
import racingcar.application.port.outbound.OutputPort;
import racingcar.application.service.CliInputPortImpl;
import racingcar.application.service.GameService;

public class AppConfig {
    private final InboundAdapter inboundAdapter;

    public AppConfig() {
        InputPort inputPort = new CliInputPortImpl();
        OutputPort outputPort = new OutputAdapter();
        GameUseCase gameUseCase = new GameService(outputPort);
        inboundAdapter = new InputAdapter(outputPort, inputPort, gameUseCase);
    }

    public InboundAdapter getCliInputAdapter() {
        return this.inboundAdapter;
    }
}
