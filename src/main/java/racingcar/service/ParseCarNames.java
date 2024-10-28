package racingcar.service;

import racingcar.constants.RacingConstant;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class ParseCarNames {

    public  List<String> parse(String carName) {
        return Arrays.stream(carName.split(RacingConstant.CAR_NAME_PARSING_DELIMETER))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();
    }
}
