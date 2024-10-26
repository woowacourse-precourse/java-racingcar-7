package racingcar;


import java.util.List;
import racingcar.io.RacingCarIOHandler;

public class RacingCarController {
    private final RacingCarIOHandler ioHandler = new RacingCarIOHandler();
    private final RacingCarGame racingCarGame = new RacingCarGame();

    public void run() {
        List<String> carNames = ioHandler.askCarNames();
        int round = ioHandler.askRound();
        String gameResult = racingCarGame.runGame(carNames, round);
        ioHandler.showGameResult(gameResult);
    }
}
