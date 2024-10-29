package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validate.Validator;

import java.util.Arrays;
import java.util.List;

public class ReaderHelper {
    private static final String DELIMITER = ",";

    public List<String> readPlayerName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(DELIMITER));
    }

    public int readPlayTime(Validator validator) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validator.validateNum(input);
        return Integer.parseInt(input);
    }
}
