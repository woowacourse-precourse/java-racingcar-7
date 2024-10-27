package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.racing.Car;
import racingcar.util.Parser;

import java.util.List;

public class InputView {
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ATTEMPT_TIMES_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<Car> readCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String userInput = Console.readLine().trim();

        return Parser.convertInputToCars(userInput);
    }

    public static int readAttemptTimes() {
        System.out.println(INPUT_ATTEMPT_TIMES_MESSAGE);
        String userInput = Console.readLine().trim();

        return Parser.parseToInteger(userInput);
    }
}
