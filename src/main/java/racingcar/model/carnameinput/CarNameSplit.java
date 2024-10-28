package racingcar.model.carnameinput;

import java.util.Arrays;
import racingcar.exception.NoCarNameException;

public class CarNameSplit {
    private static final String DELIMITER = ",";

    public static String[] nameSplit(String str) {
        String[] result = Arrays.stream(str.split(DELIMITER))
                .map(String::trim)
                .filter(name -> !name.isBlank())
                .toArray(String[]::new);

        if (result.length == 0) {
            throw new NoCarNameException();
        }

        return result;
    }
}