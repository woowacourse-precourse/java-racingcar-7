package racingcar.io;

import racingcar.RaceCars;

import java.util.List;

public class RacingCarIOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OuputHandler ouputHandler = new OuputHandler();

    public RaceCars askRaceCarsNames() {
        ouputHandler.askRaceCarsNames();
        return inputHandler.getRaceCars();
    }

    public int askRaceCount() {
        ouputHandler.askRaceCount();
        return inputHandler.getRaceCount();
    }

    public void showExecutionResult(int raceCount, RaceCars raceCars) {
        ouputHandler.showExecutionResult(raceCount, raceCars);
    }

    public void showFinalWinner(List<String> finalWinners) {
        ouputHandler.showFinalWinner(finalWinners);
    }
}
