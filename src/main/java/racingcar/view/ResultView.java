package racingcar.view;

import java.util.List;

public class ResultView {

    public void printWinners(List<String> winners) {

        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst());
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }
}
