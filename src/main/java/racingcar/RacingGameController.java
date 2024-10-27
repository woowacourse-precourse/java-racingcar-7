package racingcar;

import java.util.List;

public class RacingGameController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingGameController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void start(){
        List<String> carNames = inputHandler.readAndSplitCarNames();
        int roundNumber = inputHandler.readRoundNumber();

        Movement movement = new Movement();
        RacingGame racingGame = new RacingGame(carNames, movement);

        outputHandler.printStartMessage();

        for(int i = 0; i < roundNumber; i++) {
            racingGame.moveCars();
            outputHandler.printRoundResult(racingGame.getCars());
        }

        outputHandler.printWinners(racingGame.findWinners());
    }
}
