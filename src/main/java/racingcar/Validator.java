package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Validator {
    public static String[] getCarNames() {
        String carNamesString = Console.readLine();
        validateCarNames(carNamesString);
        return carNamesString.split(",");
    }

    public static void validateCarNames(String carNamesString) {
        if (carNamesString.isEmpty()) {
            throw new IllegalArgumentException("차 이름이 비어있습니다.");
        }
        String[] carNames = carNamesString.split(",");
        for (String carName : carNames) {
            if (carName.length() >= 5) {
                throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public static int getTrialCount() {
        String trialCountString = Console.readLine();
        validateTrialCount(trialCountString);
        return Integer.parseInt(trialCountString);
    }

    public static void validateTrialCount(String string) {
        int trialCount = Integer.parseInt(string);
        if (trialCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }
    }
}
