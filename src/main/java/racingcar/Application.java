package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int attempts = getAttempts();
    }

    // 자동차 이름 입력 받기
    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    // 시도 횟수 입력 받기
    private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
