package racingcar.util;

import java.util.List;

public class CarNameSeparator {
    private static final String CAR_NAME_Separator = ",";

    public static List<String> splitCarNameWithSeparator(String carNameGroup) {
        return List.of(carNameGroup.split(CAR_NAME_Separator));
    }
}
