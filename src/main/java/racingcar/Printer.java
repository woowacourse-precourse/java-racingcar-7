package racingcar;

import java.util.List;

public class Printer {
    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");}

    public static void promptRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCarStatus(String carName, String status) {
        if (status == null || status.isEmpty()) {
            System.out.println(carName + " : ");
        } else {
            System.out.println(carName + " : " + status);
        }
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
