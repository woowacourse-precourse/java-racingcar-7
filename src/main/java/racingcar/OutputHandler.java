package racingcar;

import java.util.List;

public final class OutputHandler {
    private OutputHandler() {
    }

    public static void printCurrentStatus(final List<Car> cars) {
        for (final Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(final List<String> winners) {
        final String winnerNames = String.join(", ", winners);
        
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptsMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printRaceResultHeader() {
        System.out.println("실행 결과");
    }
}
