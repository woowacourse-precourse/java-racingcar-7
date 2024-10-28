package racingcar.view;

import java.util.List;

public class OutputView {

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printWinner(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(",", winnerList));
    }
}
