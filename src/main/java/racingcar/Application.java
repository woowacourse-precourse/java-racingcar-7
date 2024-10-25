package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        getCarNames();
        int numberOfTries = getNumberOfTries();
    }

    // 01. 자동차 이름 입력 기능
    public static void getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 사용자 입력 받기
        String input = Console.readLine();

        // 쉼표로 구분된 자동차 이름 리스트 생성
        List<String> carNames = Arrays.asList(input.split(","));

        // 입력된 자동차 이름이 유효한지 검증
        validateCarNames(carNames);
    }

    // 01-1. 자동차 이름 예외 검증
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            // 이름이 비어 있거나 5자를 초과할 경우 예외 발생
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다: " + name);
            }
        }
    }

    // 02. 이동 횟수 입력 기능
    public static int getNumberOfTries() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine();
        return validateTries(input);
    }

    // 02-1. 입력된 시도 횟수 검증
    public static int validateTries(String input) {
        int numberOfTries;

        try {
            numberOfTries = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }

        if (numberOfTries <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 큰 숫자여야 합니다.");
        }

        return numberOfTries;
    }
}
