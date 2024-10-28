package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        List<String> carNames = getCarNames();
        // 시도 횟수 입력
        int attempts = getAttempts();

    }

    // 자동차 이름 입력
    // 입력 값 검사
    private static void validateCarNames(String input) {
        if (!input.matches("(\\b\\w{1,5}\\b)(,\\b\\w{1,5}\\b)*")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        // 정규 표현식 검사
        validateCarNames(input); // 검사 메서드 호출

        String[] nameArray = input.split(",");
        return new ArrayList<>(List.of(nameArray)); // 배열을 리스트로 변환
    }


    // 시도 횟수 입력
    private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("횟수는 1 이상의 정수여야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요.");
        }
    }
}
