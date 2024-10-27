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
        validateLength(carName);
        validateNull(carName);
    }

    public static void validateLength(String carName) {
        int length = carName.length();
        if (length >= 6) {
            throw new IllegalArgumentException("이름이 5자 이하가 아닙니다.");
        }
    }

    public static void validateNull(String carName){
        if(carName.isBlank()){
            throw new IllegalArgumentException("이름값이 공백 입니다.");
        }
    }

    public static String deleteBlank(String carName) {
        return carName.replace(" ", "");
    }

    public static void validateTryValue(String tryValue){
        validateTryValueNull(tryValue);
    }

    public static void validateTryValueNull(String tryValue) {
        if(tryValue.isBlank()){
            throw new IllegalArgumentException("시도할 횟수가 공백 입니다.");
        }
    }
}
