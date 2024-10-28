package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(", ");
        List<String> trimmedCarNames = Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
        InputValidator.validateCarNames(trimmedCarNames.toArray(new String[0]));
        return trimmedCarNames;
    }

    public int readAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        InputValidator.validateAttempts(input);
        return Integer.parseInt(input);
    }
}
