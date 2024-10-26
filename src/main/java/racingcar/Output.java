package racingcar;

import java.util.List;

public class Output {
    public static void result(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
