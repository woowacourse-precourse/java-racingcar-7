package racingcar;

import java.util.List;
import java.util.Map;

public class Output {

    private static final String TRACE = "-";

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRoundMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printCarNameAndPosition(Map<String, Integer> carsDecision) {
        carsDecision.forEach((name, position) -> {
            System.out.println(name + " : " + TRACE.repeat(position));
        });
    }

    public static void printWinner(List<String> winners) {
        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }
}
