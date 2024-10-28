package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    private static void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        validateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsInput = Console.readLine();
        int attempts = Integer.parseInt(attemptsInput);
        validateAttempts(attempts);

        // 입력값을 이후 로직에서 사용할 수 있도록 처리할 수 있습니다.
    }

    private static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
            }
        }
    }

    private static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
