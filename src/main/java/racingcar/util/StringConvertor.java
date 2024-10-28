package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.model.RacingCar;

public class StringConvertor {
    private StringConvertor() {}

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<RacingCar> toCarList(String input) {
        String[] carNames = input.split(",");
        return Arrays.stream(carNames).map(RacingCar::new).toList();
    }
}
