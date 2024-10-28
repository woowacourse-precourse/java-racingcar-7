package racingcar;

import racingcar.controller.Referee;

public class Application {
    public static void main(String[] args) {
        Referee referee = new Referee();
        referee.startGame();
    }
}
