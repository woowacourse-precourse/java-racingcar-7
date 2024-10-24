package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    public static ArrayList<String> toArrayList(String nameString){
        return new ArrayList<>(Arrays.asList(nameString.split(Constants.CAR_NAME_DELIMITER)));
    }
}
