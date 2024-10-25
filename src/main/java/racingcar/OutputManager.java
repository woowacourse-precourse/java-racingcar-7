package racingcar;

import java.util.List;

public class OutputManager {

    private static final String GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String WINNER_RESULT_MESSAGE = "최종 우승자 : ";
    private static final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ", ";

    public static void printGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    public static void printWinner(List<String> winnerList) {
        String joinedName = String.join(DELIMITER, winnerList);
        System.out.println(WINNER_RESULT_MESSAGE + joinedName);
    }

    public static void printTryCountMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }
}
