package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    static List<String> carNamesList;
    static int gameRepeats;
    static Game game;

    public static void main(String[] args) {
        initGame();
        GameValidations.validate(carNamesList, gameRepeats);
        startGame();
        game.printWinners();
    }

    public static void initGame() {
        carNamesList = User.inputCarNames();
        gameRepeats = User.inputGameRepeats();
        Console.close();
        game = new Game(carNamesList);
    }

    public static void startGame() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameRepeats; i++) {
            game.moveCar();
            game.printProgress();
        }
    }
}
