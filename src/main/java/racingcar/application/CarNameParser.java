package racingcar.application;

import racingcar.common.Validator;
import racingcar.model.CarName;
import racingcar.model.RawInput;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class CarNameParser implements Parser {

    @Override
    public List<CarName> getParsedCarNameList(RawInput carNameString) {

        Set<String> carNameSet = new HashSet<>();

        List<CarName> carNameList = Stream.of(carNameString.rawInput().split(","))
                .filter(name -> isAlreadyExistName(carNameSet, name))
                .map(CarName::of)
                .toList();

        Validator.validateCarNameListLength(carNameList);

        return carNameList.stream().toList();
    }

    private boolean isAlreadyExistName(Set<String> carNameSet, String name) {
        if (!carNameSet.contains(name)) {
            carNameSet.add(name);
            return true;
        }
        return false;
    }
}
