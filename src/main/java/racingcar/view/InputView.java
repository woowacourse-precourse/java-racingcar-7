package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.validator.InputValidator;

public class InputView {

    private final class InputViewConstant {
        public static final String READ_CAR_MESSAGE
            = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        public static final String READ_NUM_MESSAGE = "시도할 횟수는 몇 회인가요?";
        public static final String COMMA = ",";
    }

    public static List<String> readCarNames() {
        System.out.println(InputViewConstant.READ_CAR_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateCarNames(input);
        return Arrays.asList(input.split(InputViewConstant.COMMA));
    }

    public static int readNumberOfTrial() {
        System.out.println(InputViewConstant.READ_NUM_MESSAGE);
        String numberOfTrial = Console.readLine();
        InputValidator.validateNumberOfTrial(numberOfTrial);
        return Integer.parseInt(numberOfTrial);
    }
}
