package racingcar;

import racingcar.adapter.inbound.cli.InputAdapter;
import racingcar.adapter.outbound.cli.OutputAdapter;
import racingcar.application.port.inbound.GameUseCase;
import racingcar.application.port.inbound.InputPort;
import racingcar.application.port.outbound.OutputPort;
import racingcar.application.service.CliInputPortImpl;
import racingcar.application.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final OutputPort outputPort = new OutputAdapter();
        final InputPort inputPort = new CliInputPortImpl();
        final GameUseCase gameUseCase = new GameService(outputPort);
        final InputAdapter inputAdapter = new InputAdapter(outputPort, inputPort, gameUseCase);
        inputAdapter.run();
    }
}
