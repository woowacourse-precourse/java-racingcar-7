package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    private static final String POSITION_COUNT_CHARACTER = "-";
    private static final String POSITION_NAME_DELIMITER = " : ";
    private static final String RESULT_WINNER_DELIMITER = ", ";

    public void displayCurrentPosition(Map<String, Long> position) {
        for (Entry<String, Long> car : position.entrySet()) {
            System.out.println(getCarPositionString(car.getKey(), car.getValue()));
        }
        System.out.println();
    }

    public void displayResult(List<String> winners) {
        String result = String.join(RESULT_WINNER_DELIMITER, winners);

        System.out.print("최종 우승자 : " + result);
    }

    private String getCarPositionString(String carName, Long position) {
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionString.append(POSITION_COUNT_CHARACTER);
        }
        return carName + POSITION_NAME_DELIMITER + positionString;
    }
}
