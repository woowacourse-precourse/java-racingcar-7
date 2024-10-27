package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNameInput = inputCarNames();
        int attemptNumber = inputAttemptNumber();

        RacingGame game = new RacingGame(carNameInput, attemptNumber);
        game.play();
        game.printWinners();
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNames(carNames);

        return input;
    }

    private static int inputAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}

