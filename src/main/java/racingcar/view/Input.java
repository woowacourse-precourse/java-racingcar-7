package racingcar.view;

import racingcar.view.util.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.util.ViewMessage.자동차_이름_입력;
import static racingcar.view.util.ViewMessage.총_라운드_입력;

public class Input {
    private final Validator validator;

    private final String COMMA = ",";

    protected Input() {
        validator = new Validator();
    }

    public static Input of() {
        return new Input();
    }

    public List<String> getCarnames() {
        System.out.println(자동차_이름_입력.getMessage());
        return splitCarnames(getInput());
    }

    public Integer getTotalRound() {
        System.out.println(총_라운드_입력.getMessage());
        return parserTotalRound(getInput());
    }

    public List<String> splitCarnames(String inputData) {
        List<String> carnames = List.of(inputData.split(COMMA));
        validator.validateMinCarCount(carnames);
        validator.validateCarNameLength(carnames);
        return carnames;
    }

    public Integer parserTotalRound(String inputData) {
        Integer number = validator.tryParserToInt(inputData);
        validator.validatePositiveNumber(number);
        return number;
    }

    public String getInput() {
        return readLine();
    }
}
