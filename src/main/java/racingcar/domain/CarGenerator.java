package racingcar.domain;

import static racingcar.constant.SeparatorConstant.COMMA;
import static racingcar.constant.SeparatorConstant.EMPTY;
import static racingcar.constant.SeparatorConstant.SPACE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {
    public static List<Car> getParticipateCars(String input) {
        return Arrays.stream(input.replaceAll(SPACE.getSeparator(), EMPTY.getSeparator())
                        .split(COMMA.getSeparator()))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
