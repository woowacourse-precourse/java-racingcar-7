package racingcar.factory;

import racingcar.common.Symbol;
import racingcar.validator.InputValidator;

import java.util.List;

public class StringParserFactory {

    private final InputValidator inputValidator = new InputValidator();

    public void parseCarName(String inputCarName) {
        List<String> carNameList = List.of(inputCarName.split(Symbol.COMMA));
        inputValidator.validateCarName(carNameList);
    }

    public void parseLoopCount(String inputLoopCount) {
        inputValidator.validateLoopCount(inputLoopCount);
    }
}
