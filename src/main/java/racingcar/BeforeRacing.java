package racingcar;

import java.util.ArrayList;
import java.util.List;

public class BeforeRacing {

    public static List<String> divideCarName(String carNameString) {
        List<String> carNameList = new ArrayList<>();
        String[] splitName = carNameString.split(",");
        for (String name : splitName) {
            String trimmedName = deleteBlank(name);
            validateName(trimmedName);
            carNameList.add(trimmedName);
        }
        return carNameList;
    }

    public static void validateName(String carName) {
        int length = carName.length();
        if (length >= 6) {
            throw new IllegalArgumentException("이름이 5자 이하가 아닙니다.");
        }
    }

    public static String deleteBlank(String carName) {
        return carName.replace(" ", "");
    }

}
