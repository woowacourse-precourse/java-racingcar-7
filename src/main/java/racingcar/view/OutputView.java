package racingcar.view;

import java.util.List;

public class OutputView {
    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            if (i != winners.size() - 1) {
                System.out.print(winners.get(i) + ",");
            }else System.out.print(winners.get(i));
        }
    }
}
