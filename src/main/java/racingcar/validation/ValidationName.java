package racingcar.validation;


import java.util.ArrayList;

public class ValidationName {

    public static void validateName(String carName) {
        String regex = "^[a-zA-Z0-9가-힣]+$";
        isNameEmpty(carName);
        validateNameInput(carName, regex);
        validateNameLength(carName);
    }

    public static void isNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름이 제대로 입력되지 않았습니다.");
        }
    }

    public static void validateNameInput(String carName, String regex) {
        if (!carName.matches(regex)) {
            throw new IllegalArgumentException("이름은 영문, 한글, 숫자로 띄어쓰기없이 입력하십시오.");
        }
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 넘기면 안됩니다.");
        }
    }

    public static void validateSameName(ArrayList<String> carNameArray, String carName) {
        if (carNameArray.contains(carName)) {
            throw new IllegalArgumentException("동일한 이름은 작성할 수 없습니다.");
        }
    }
}
