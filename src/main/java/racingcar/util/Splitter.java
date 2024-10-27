package racingcar.util;

import racingcar.dto.RacingInputReq;
import racingcar.model.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    public List<Car> splitSeparator(RacingInputReq racingInputReq) {
        final String COMMA = ",";

        return Arrays.stream(racingInputReq.getCarNames().split(COMMA))
                .map(String::trim)
                .filter(name -> !name.isBlank())
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
