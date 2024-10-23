package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static String INVAILD_INPUT_MESSAGE = "잘못된 입력입니다. ";
    static List<String> carNames = new ArrayList<>();

    public static void main(String[] args) {
        // 입력
        input();
    }

    private static void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = List.of(Console.readLine().split(","));
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCountStr = Console.readLine();
    }
}
