package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String[] args) {

        String inputNames = Console.readLine();


        int rounds = Integer.parseInt(Console.readLine());

        RacingGame game = new RacingGame(inputNames, rounds);
        game.play();
    }
}
