package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printEmptyLine() {
        System.out.println();
    }

    public void printRoundResultText() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<String> carNames, Map<String, Integer> carPositions) {
        for (String car : carNames) {
            String resultLine = createCarPositionLine(car, carPositions.get(car));
            System.out.println(resultLine);
        }
    }

    private String createCarPositionLine(String carName, int position) {
        return carName + " : " + "-".repeat(position);
    }
}
