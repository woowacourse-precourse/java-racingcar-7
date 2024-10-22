package racingcar.view;

import java.util.List;

public class OutputView {

    public void printResultText() {
        System.out.println(DisplayedMessage.OUTPUT_EXECUTE_RESULT_TEXT.getValue());
    }

    public void printMoveResult(List<String> carMoveResultList) {
        StringBuilder sb = new StringBuilder();
        carMoveResultList.forEach(sb::append);
        System.out.println(sb);
    }
}
