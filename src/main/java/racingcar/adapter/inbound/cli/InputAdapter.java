package racingcar.adapter.inbound.cli;

import racingcar.application.port.inbound.GameUseCase;

public class InputAdapter {
    private final GameUseCase gameUseCase;

    public InputAdapter(GameUseCase gameUseCase) {
        this.gameUseCase = gameUseCase;
    }

    public void run() {
        gameUseCase.execute();
    }
}
