package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    public static List<String> inputCarName() {
        String input = Console.readLine();
        checkInput(input);
        List<String> carList = Arrays.asList(input.split(","));
        checkCarName(carList);
        return carList;
    }

    public static int inputRoundCount() {
        String input = Console.readLine();
        checkInput(input);
        return checkRoundCount(input);
    }

    private static void checkInput(String input) {
        if(input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("빈 문자열입니다.");
    }

    private static void checkCarName(List<String> carList) {
        for(String carName : carList) {
            checkInput(carName);
            checkCarNameLength(carName);
        }
    }

    private static int checkRoundCount(String input) {
        try {
            int roundCount = Integer.parseInt(input);
            checkRoundCountPositive(roundCount);
            return roundCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
    }

    private static void checkCarNameLength(String carName) {
        if(carName.length() > 5)
            throw new IllegalArgumentException("각 이름은 5자 이하여야 합니다.: " + carName);
    }

    private static void checkRoundCountPositive(int roundCount) {
        if(roundCount <= 0)
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.: " + roundCount);
    }
}
