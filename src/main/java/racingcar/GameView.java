package racingcar;

import static racingcar.OutputMessage.*;

import java.util.List;

public class GameView {
    public void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE.getMessage());
    }

    public void printRoundCountInputMessage() {
        System.out.println(ROUND_COUNT_INPUT_MESSAGE.getMessage());
    }

    public void printRoundResult(List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }
}
