package racingcar.application;

import racingcar.common.Validator;
import racingcar.model.CarName;
import racingcar.model.RawInput;

import java.util.List;
import java.util.stream.Stream;

public class CarNameParser implements Parser{
    @Override
    public List<CarName> getParsedCarNameList(RawInput carNameString) {

        List<CarName> carNameList = Stream.of(carNameString.rawInput().split(","))
                .map(CarName::of)
                .toList();

        Validator.validateCarNameListLength(carNameList);

        return carNameList;
    }
}
