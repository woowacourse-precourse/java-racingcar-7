package racingcar.io;

import racingcar.RaceCars;

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

}
