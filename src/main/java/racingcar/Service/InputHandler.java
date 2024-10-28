package racingcar.Service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Utils.ApplicationConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분, 최대 5자)");
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(String::trim) // 공백 제거
                .filter(name -> name.length() <= 5) // 최대 5자 제한
                .collect(Collectors.toList()); // List<String> 반환
    }

    public int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            int numberOfAttempts = Integer.parseInt(input);
            validateAttempts(numberOfAttempts);
            return numberOfAttempts;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ApplicationConstants.INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }

    private void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException(ApplicationConstants.INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }
}