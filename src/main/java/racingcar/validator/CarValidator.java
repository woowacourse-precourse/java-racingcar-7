package racingcar.validator;

import racingcar.model.Car;

import java.util.Set;

public class CarValidator {
    private static final int NAME_MAX_LENGTH = 5;

    public static void validateCarName(String name, Set<String> existingNames) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 1글자 이상부터 가능합니다.");
        }
        if (!existingNames.add(name)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateDuplication(Set<Car> cars){

    }

    public static void validateAttempts(String attempts){
        if (!attempts.matches("\\d+")) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
        }
        if (Integer.parseInt(attempts) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
