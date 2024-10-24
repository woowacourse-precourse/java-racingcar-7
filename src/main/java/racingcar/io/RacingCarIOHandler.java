package racingcar.io;

import java.util.List;
import racingcar.car.RacingCar;

public class RacingCarIOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public List<String> askCarNames() {
        outputHandler.showCarNameInputMessage();
        return inputHandler.getCarNames();
    }

    public int askRound() {
        outputHandler.showRoundInputMessage();
        return inputHandler.getRound();
    }

    public void showExecutionResultMessage() {
        outputHandler.showExecutionResultMessage();
    }

    public void showRacingCarsProgress(List<RacingCar> cars) {
        outputHandler.showRacingCarsProgress(cars);
    }

    public void showWinners(List<String> winners) {
        outputHandler.showWinners(winners);
    }

}
