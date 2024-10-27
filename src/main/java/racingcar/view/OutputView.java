package racingcar.view;

import racingcar.domain.Race;

import java.util.List;

public class OutputView {
    private static final String GAME_START_OUTPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_OF_ATTEMPTS_OUTPUT = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_OUTPUT = "실행 결과";
    private static final String BETWEEN_NAME_AND_POSITION = " : ";
    private static final String POSITION_COUNT_PREFIX = "-";
    private static final String WINNER_OUTPUT = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String NEXT_LINE = "\n";

    public static void renderFirstRun() {
        System.out.println(GAME_START_OUTPUT);
    }

    public static void renderAttemptCountInput() {
        System.out.println(COUNT_OF_ATTEMPTS_OUTPUT);
    }

    public static void preRenderResult() {
        System.out.println(NEXT_LINE + RESULT_OUTPUT);
    }

    public static void renderResult(Race race) {
        race.getRaceCars().forEach(car -> {
            System.out.print(car.getName() + BETWEEN_NAME_AND_POSITION);
            renderCurrentPosition(car.getPosition());
            System.out.print(NEXT_LINE);
        });
        System.out.println();
    }

    private static void renderCurrentPosition(int position) {
        System.out.print(POSITION_COUNT_PREFIX.repeat(position));
    }

    public static void renderWinners(List<String> winners) {
        System.out.print(WINNER_OUTPUT);
        System.out.print(String.join(WINNER_DELIMITER, winners));
    }

}
