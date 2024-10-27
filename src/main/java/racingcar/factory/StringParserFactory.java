package racingcar.factory;

import racingcar.common.Symbol;
import racingcar.validator.InputValidator;

import java.util.List;

public class StringParserFactory {

    private final InputValidator inputValidator = new InputValidator();

    public List<String> parseCarName(String inputCarName) {
        List<String> carNameList = List.of(inputCarName.split(Symbol.COMMA));
        inputValidator.validateCarName(carNameList);
        return carNameList;
    }

    public int parseLoopCount(String inputLoopCount) {
        inputValidator.validateLoopCount(inputLoopCount);
        return Integer.parseInt(inputLoopCount);
    }
}
