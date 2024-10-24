package racingcar.view;

import static racingcar.global.Message.WINNER;

import java.util.List;

public class OutputView {

    public void printWinner(List<String> winners) {
        System.out.print(WINNER + " ");
        System.out.print(String.join(",", winners));
    }
}
