package racingcar;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final int MAX_LENGTH = 5;

    List<String> getCarNames() {
        String carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        carNames = Console.readLine();
        return parseCarNames(carNames);
    }

    List<String> parseCarNames(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야합니다.");
        }
        return Arrays.asList(carNames.split(","));
    }

    boolean isCarNameLengthValid(String carName) {
        return carName != null && carName.length() <= MAX_LENGTH;
    }

    boolean areAllCarNameLengthsValid(List<String> carNames) {
        boolean areValid = carNames.stream().allMatch(this::isCarNameLengthValid);
        if (!areValid) {
            throw new IllegalArgumentException("자동차 이름은 최대 " + MAX_LENGTH + "자까지 가능");
        }
        return true;
    }

    int getMoveCount() {
        int moveCount;
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            moveCount = Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.", e);
        }
        return moveCount;
    }

    boolean isValidMoveCount(int moveCount) {

    }


}
