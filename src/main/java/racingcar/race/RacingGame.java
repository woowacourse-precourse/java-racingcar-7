package racingcar.race;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.race.model.Car;

public class RacingGame {

    public static final String CAR_NAME_TO_ENTER_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String NUMBER_OF_ATTEMPTS_TO_ENTER_TEXT = "시도할 횟수는 몇 회인가요?";
    public static final String ERROR_MESSAGE_IF_IT_IS_NOT_A_NUMBER = "숫자를 입력해야합니다.";
    public static final String NAME_RULE_DELIMITER = ",";

    public void start() {
        List<Car> cars = inputNames().stream().map(Car::new).toList();
        int tryCount = inputTry();
    }

    private List<String> inputNames() {
        System.out.println(CAR_NAME_TO_ENTER_TEXT);

        return Arrays.stream(Console.readLine().split(NAME_RULE_DELIMITER))
                .map(String::trim)
                .toList();
    }

    private int inputTry() {
        System.out.println(NUMBER_OF_ATTEMPTS_TO_ENTER_TEXT);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_IF_IT_IS_NOT_A_NUMBER);
        }
    }
}
