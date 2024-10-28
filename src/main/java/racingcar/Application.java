package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        GameEngine gameEngine = new GameEngine(inputReader);

        gameEngine.readUserInput();
        gameEngine.initializeGame();
        gameEngine.run();
    }
}
