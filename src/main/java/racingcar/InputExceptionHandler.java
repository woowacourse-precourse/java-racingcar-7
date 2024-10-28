package racingcar;

import java.util.Arrays;

public class InputExceptionHandler {
    public void validCarName(String inputCarName) throws IllegalArgumentException {
        Arrays.stream(inputCarName.split(","))
                .map(String::trim)
                .forEach(carName -> {
                    if(carName.isEmpty()) {
                        throw new IllegalArgumentException("차 이름이 공백일 수 없습니다.");
                    }
                    if(carName.length() > 5) {
                        throw new IllegalArgumentException("차 이름은 5글자를 초과 할 수 없습니다.");
                    }
                });
    }

    public void validAttemptNumber(String inputNumber) throws IllegalArgumentException {
        if(inputNumber == null) {
            throw new IllegalArgumentException("입력을 확인해주세요.");
        }
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        if(Integer.parseInt(inputNumber) < 0) {
            throw new IllegalArgumentException("0 미만의 수는 입력할 수 없습니다.");
        }
    }
}
