package racingcar.application;

import racingcar.model.CarName;
import racingcar.model.RawInput;

import java.util.List;

public interface Parser {
    List<CarName> getParsedCarNameList(RawInput carNameString);
}
