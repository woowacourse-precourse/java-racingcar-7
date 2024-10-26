package racingcar.validation;


import java.util.ArrayList;

public class Validation {

    public static void validateName(String carName) {
        String regex = "^[a-zA-Z0-9가-힣]+$";

        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름이 제대로 입력되지 않았습니다.");
        } else if (!carName.matches(regex)) {
            throw new IllegalArgumentException("이름은 영문, 한글, 숫자로 띄어쓰기없이 입력하십시오.");
        } else if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 넘기면 안됩니다.");
        }
    }

    public static void validateSameName(ArrayList<String> carNameArray, String carName) {
        if (carNameArray.contains(carName)) {
            throw new IllegalArgumentException("동일한 이름은 작성할 수 없습니다.");
        }
    }

    public static int validateGameCount(String gameCount) {
        int attempt;
        try {
            attempt = Integer.parseInt(gameCount);
            validNegativeNumber(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("0~2^31-1의 정수로만 횟수를 입력하세요(문자, 소수 불가).");
        }
        return attempt;
    }

    public static void validNegativeNumber(int attempt) {
        if (attempt < 0) {
            throw new IllegalArgumentException("음수로는 시도 횟수를 측정하지 못합니다.");
        }
    }
}
