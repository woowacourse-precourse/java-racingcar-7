package util;

public class Validator {
    public static void validateInputDate(String[] inputCars) {
        for (String car : inputCars) {
            isCarNameLongerThanFive(car);
        }
    }

    private static void isCarNameLongerThanFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자 입니다.");
        }
    }
}
