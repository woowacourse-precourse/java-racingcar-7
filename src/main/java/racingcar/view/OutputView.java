package racingcar.view;

import java.util.List;
import racingcar.model.CarName;
import racingcar.model.Distance;

public class OutputView {
    private static final String INPUT_CAR_NAME_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_COUNT_GUIDE = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTION_RESULT = "\n실행 결과";
    private static final String ROAD_EXPRESSION = "-";
    private static final String NAME_SCORE_DELIMITER = " : ";
    private static final String LAST_WINNER = "최종 우승자 : ";

    public static void printCarNameGuide() {
        System.out.println(INPUT_CAR_NAME_GUIDE);
    }

    public static void printRaceCountGuide() {
        System.out.println(INPUT_RACE_COUNT_GUIDE);
    }

    public static void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printNowCarScore(CarName carName, Distance distance) {
        System.out.println(carName.getCarName() + NAME_SCORE_DELIMITER
                + ROAD_EXPRESSION.repeat(distance.getDistance()));
    }

    public static void printFinalWinner(List<String> lastWinners) {
        System.out.println(LAST_WINNER + String.join(", ", lastWinners));
    }
}
