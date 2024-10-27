package racingcar;

import racingcar.io.RacingCarIOHandler;

public class RacingCarGame {

    private final RacingCarIOHandler racingCarIOHandler = new RacingCarIOHandler();

    public void run() {
        
        RaceCars raceCars = racingCarIOHandler.askRaceCarsNames();
    }
}