package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.util.InputHandler;
import racingcar.util.OutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        RacingGameController gameController = new RacingGameController();
        try{
            String names = inputHandler.getCarsName();
            String tryCount = inputHandler.getTryCount();
            gameController.addCars(names);
            int count = Integer.parseInt(tryCount);
            for (int i = 0; i < count; i++) {
                gameController.race();
                outputHandler.printCurrentResult(gameController.getResult());
            }
            outputHandler.printFinalResult(gameController.getWinners());
        }catch(IllegalArgumentException e){
            outputHandler.printError(e.getMessage());
            throw e;
        }
    }
}
