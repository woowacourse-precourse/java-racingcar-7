package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> returnCarNames = processCarNames(input);

        return returnCarNames;
    }

    public static List<String> processCarNames(String input) {
        validateInput(input);
        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }


    private static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
    }

    private static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateCarName(name);
        }
    }


    private static void validateCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. 입력된 이름: " + name);
        }
    }

}
