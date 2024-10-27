package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public static String getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        validateCarNames(carNamesInput);
        return carNamesInput;
    }

    public static int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfAttempts = Integer.parseInt(Console.readLine());
        validateNumberOfAttempts(numberOfAttempts);
        return numberOfAttempts;
    }

    private static void validateCarNames(String carNamesInput) {
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다: " + name);
            }
        }
    }

    private static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상이어야 합니다.");
        }
    }
}
