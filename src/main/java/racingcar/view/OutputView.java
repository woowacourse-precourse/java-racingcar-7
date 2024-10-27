package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String WELCOME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAMES_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String ROUND_RESULTS_PREFIX = "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";

    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printCarNamesPrompt() {
        System.out.println(CAR_NAMES_PROMPT);
    }

    public static void printInitialStatus() {
        System.out.println("\n" + ROUND_RESULTS_PREFIX);
    }

    public static void printRoundResults(List<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(WINNERS_MESSAGE + String.join(", ", winners));
    }
}
