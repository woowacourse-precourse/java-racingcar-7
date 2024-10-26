package racingcar;

import java.util.List;

public class OutputView {

    public void displayResult(List listWinner) {
        System.out.print("최종 우승자 : " + String.join(",", listWinner));
    }

}
