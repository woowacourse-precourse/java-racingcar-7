package racingcar.race.domain;

public class RaceMessage {
    public static final String ENTER_ROUND = "시도할 횟수는 몇 회인가요?";
    public static final String RACE_ALTER = "실행 결과";

    public static void printMessage() {
        System.out.println(ENTER_ROUND);
    }

    public static void outputMessage() {
        System.out.println();
        System.out.println(RACE_ALTER);
    }
}
