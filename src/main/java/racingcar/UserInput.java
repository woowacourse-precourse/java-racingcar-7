package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    private final InputValidator inputValidator = new InputValidator();

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarNames = Console.readLine();
        List<String> racingCarNames = parseCarNames(rawCarNames);

        inputValidator.checkCarCount(racingCarNames);
        inputValidator.checkNameLength(racingCarNames);
        inputValidator.checkForWhitespace(racingCarNames);
        inputValidator.checkForDuplicates(racingCarNames);

        return racingCarNames;
    }

    private List<String> parseCarNames(String rawCarNames) {
        return Arrays.asList(rawCarNames.split(","));
    }

    public int readRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
