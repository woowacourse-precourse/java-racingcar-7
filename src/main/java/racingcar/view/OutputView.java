package racingcar.view;

import java.util.Map;

public class OutputView {

    public static final String RESULT_START_MESSAGE = "실행 결과";

    public void showCurrentStatus(Map<String, Integer> gameDataMap) {
        gameDataMap.forEach((carName, position) -> {
            System.out.println(carName + " : " + "-".repeat(position));
        });
        System.out.println();
    }

    public void showStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
    }
}
