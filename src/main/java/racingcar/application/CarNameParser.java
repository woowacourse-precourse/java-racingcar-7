package racingcar.application;

import racingcar.common.Validator;
import racingcar.model.CarName;
import racingcar.model.RawInput;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarNameParser implements Parser {

    @Override
    public Set<CarName> getParsedCarNameList(RawInput carNameString) {

        Set<CarName> carNameList = Stream.of(carNameString.rawInput().split(","))
                .map(CarName::of)
                .collect(Collectors.toSet());

        Validator.validateCarNameListLength(carNameList);

        return carNameList;
    }
}
