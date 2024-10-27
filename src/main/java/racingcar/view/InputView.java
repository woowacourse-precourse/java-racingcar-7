package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        validateCarNames(carNames);
        return carNames;
    }

    public static int getTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            int trialCount = Integer.parseInt(input);
            validateTrialCount(trialCount);
            return trialCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void validateTrialCount(int trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}