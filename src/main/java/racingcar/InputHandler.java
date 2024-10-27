package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    public List<String> readAndSplitCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        validateCarNames(input);

        return Arrays.asList(input.split(","));
    }

    public int readRoundNumber() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String input = Console.readLine();

        return validateAndParseRoundNumber(input);
    }

    public void validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있거나 공백 문자만 포함되어 있습니다.");
        }

        final String carNameRegex = "^[a-zA-Z0-9]{1,5}$";

        for (String carName : input.split(",")) {
            if(!carName.matches(carNameRegex)) {
                throw new IllegalArgumentException("자동차 이름은 영어와 숫자만을 사용해서 만들 수 있고, 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    public int validateAndParseRoundNumber(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있거나 공백 문자만 포함되어 있습니다.");
        }

        int roundNumber = 0;

        try {
            roundNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        if (roundNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        return roundNumber;
    }

}
