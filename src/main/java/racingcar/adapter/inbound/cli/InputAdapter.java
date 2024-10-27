package racingcar.adapter.inbound.cli;

import racingcar.application.dto.RacingGameRequest;
import racingcar.application.port.inbound.GameUseCase;
import racingcar.application.port.inbound.InputPort;
import racingcar.application.port.outbound.OutputPort;

public class InputAdapter {
    private final OutputPort outputPort;
    private final InputPort inputPort;
    private final GameUseCase gameUseCase;

    public InputAdapter(OutputPort outputPort, InputPort inputPort, GameUseCase gameUseCase) {
        this.outputPort = outputPort;
        this.inputPort = inputPort;
        this.gameUseCase = gameUseCase;
    }

    public void run() {
        outputPort.writeMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String cars = inputPort.get();
        outputPort.writeMessage("시도할 횟수는 몇 회인가요?");
        final String repeat = inputPort.get();

        final RacingGameRequest request = new RacingGameRequest(cars, repeat);

        gameUseCase.execute(request);
    }
}
