package racingcar.view;

import java.util.List;

public class ResultView {

    public static void showWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
