package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();
        int playCount = Integer.parseInt(Console.readLine());

        RacingGame game = new RacingGame(playCount);

        game.createCar(str);

        for (int i = 0; i < playCount; i++) {
            System.out.println(game.playGame());
        }

        System.out.println(game.printWinner());
    }
}
