package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        String input = Console.readLine();
        game.registerCars(input);
        String numInput = Console.readLine();
        //RacingGame::setTryCount();
        //RacingGame::doGame();
        Console.close();
    }
}
