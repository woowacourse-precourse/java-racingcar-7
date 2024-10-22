package racingcar;

import racingcar.io.RacingCarIOHandler;

public class RacingCarGame {

    private final RacingCarIOHandler ioHandler = new RacingCarIOHandler();

    public void run(){
        // 입력에 대한 검증 필요
        String carNamesString = ioHandler.askCarNames();
        String roundCountString = ioHandler.askRoundCount();

    }
}
