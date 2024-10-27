package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {
    public String requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        validateFormat(carNames);
        validateString(carNames);
        validateUnique(carNames);
        return carNames;
    }

    public String requestRaceRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceRounds = Console.readLine();

        validateFormat(raceRounds);
        validateInteger(raceRounds);
        return raceRounds;
    }

    private void validateFormat(String input) {
        if (input == null || input.isEmpty() || input.equals(" ")) {
            throw new IllegalArgumentException("잘못된 입력입니다. 널, 개행, 공백 문자가 아닌 문자열을 입력해주세요.");
        }
    }

    private void validateString(String input) {
        if (input.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 포함되지 않은 문자열을 입력해주세요.");
        }
    }

    private void validateUnique(String carNames) {
        String[] splitCarNames = carNames.split(",");
        List<String> carNamesList = Arrays.asList(splitCarNames);
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : carNamesList) {
            if (uniqueCarNames.contains(carName)) {
                throw new IllegalArgumentException("잘못된 입력입니다. 중복되지 않는 이름을 입력해주세요.");
            }
            uniqueCarNames.add(carName);
        }
    }

    private void validateInteger(String raceRounds) {
        try {
            int rounds = Integer.parseInt(raceRounds);

            if (rounds <= 0) {
                throw new IllegalArgumentException("잘못된 값입니다. 시도 횟수로 1회 이상의 값을 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값입니다. 시도 횟수로 int형 값을 입력해주세요.");
        }
    }
}