package racingcar.application;

import racingcar.model.CarName;
import racingcar.model.RawInput;

import java.util.Set;

public interface Parser {
    Set<CarName> getParsedCarNameList(RawInput carNameString);
}
