package racingcar;

import java.util.List;

import racingcar.controller.RacingGame;
import racingcar.view.input;

public class Application {

    public static void main(String[] args) {
        input input = new input();
        List<String> carNameList = input.getCarNames();
        String[] carNames = carNameList.toArray(new String[0]); // List를 String[]로 변환
        int attemptCount = input.getAttemptCount();

        try {
            RacingGame racingGame = new RacingGame(carNames, attemptCount);
            racingGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}p