package racingcar.application;

import java.util.List;

public class CarNameParser implements Parser{
    @Override
    public List<String> getParsedCarNameList(String carNameString) {
        List<String> carNameList = List.of(carNameString.split(","));
        return carNameList;
    }
}
