package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int attempts = getAttempts();
        validateCarNames(carNames);
        validateAttempts(attempts);
    }

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    // 자동차 이름 유효성 검사
    private static void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    // 시도 횟수 유효성 검사
    private static void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }
    }
}
