package racingcar;

import java.util.List;

public class Output {
    public static void result(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public static void playRacing() {
        System.out.println("\n실행 결과");
    }
}
