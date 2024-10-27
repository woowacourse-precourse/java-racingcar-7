package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.StringParser;
import racingcar.util.Validator;

public class InputHandler {
    private static final String REQUEST_MESSAGE_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_MESSAGE_ROUND = "시도할 횟수는 몇 회인가요?";

    private final Validator validator;
    private final StringParser stringParser;

    public InputHandler(Validator validator, StringParser stringParser) {
        this.validator = validator;
        this.stringParser = stringParser;
    }

    public List<String> getInputAboutCars() {
        System.out.println(REQUEST_MESSAGE_CAR);
        String input = Console.readLine();
        validator.checkAboutCars(input);

        return stringParser.makeList(input);
    }

    public int getInputAboutRound() {
        System.out.println(REQUEST_MESSAGE_ROUND);
        String input = Console.readLine();
        validator.checkAboutRound(input);

        return Integer.parseInt(input);
    }
}
