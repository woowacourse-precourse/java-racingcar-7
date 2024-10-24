package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNamesList = User.inputCarNames();
        int gameRepeats = User.inputGameRepeats();
        Console.close();

        Game game = new Game(carNamesList);

        startGame(game, gameRepeats);

        game.printWinners();
    }

    public static void startGame(Game game, int repeats) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < repeats; i++) {
            game.moveCar();
            game.printProgress();
        }
    }
}
