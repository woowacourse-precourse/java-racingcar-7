package racingcar;

import racingcar.adapter.inbound.cli.InputAdapter;
import racingcar.adapter.outbound.cli.OutputAdapter;
import racingcar.application.port.inbound.GameUseCase;
import racingcar.application.service.CliInputPortImpl;
import racingcar.application.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameUseCase gameUseCase = new GameService(new CliInputPortImpl(), new OutputAdapter());
        InputAdapter inputAdapter = new InputAdapter(gameUseCase);
        inputAdapter.run();
    }
}
