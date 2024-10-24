package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(User.inputCarNames());
        int gameRepeats = User.inputGameRepeats();

        Console.close();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameRepeats; i++) {
            game.moveCar();
            game.printProgress();
        }
        game.printWinners();
    }
}
