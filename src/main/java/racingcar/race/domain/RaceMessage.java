package racingcar.race.domain;

public class RaceMessage {
    public static final String ENTER_ROUND = "시도할 횟수는 몇 회인가요?";

    public static void printMessage() {
        System.out.println(ENTER_ROUND);
    }
}
