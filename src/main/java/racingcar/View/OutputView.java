package racingcar.View;

import java.util.List;

public class OutputView {
    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
