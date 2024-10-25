package racingcar.view;

import static racingcar.global.constant.GameMessage.*;

public class OutputView {
    public void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputGameRoundMessage() {
        System.out.println(INPUT_GAME_ROUND_MESSAGE);
    }

    public void printGameRoundResult(String name, String movement) {
        System.out.println(name + " : " + movement);
    }

    public void printGameWinner(String winner) {
        System.out.println(OUTPUT_GAME_WINNER_MESSAGE + winner);
    }
}
