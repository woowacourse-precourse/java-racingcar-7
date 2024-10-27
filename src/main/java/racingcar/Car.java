package racingcar;

import java.util.Collections;
import java.util.Map;

public class Car {

    private static int CAR_NAME_MIN = 1;
    private static int CAR_NAME_MAX = 5;
    private static int CAR_MOVE_RULE = 4;

    private String name;
    private int position;

    public Car(String name) {
        checkCarNameUnderRule(name);
        checkCarNameOverRule(name);
        checkCarNameBlank(name);
        this.name = name;
    }

    public void decideMoving(int number) {
        if (number >= CAR_MOVE_RULE) {
            this.position++;
        }
    }

    public Map<String, Integer> tellDecision() {
        return Collections.singletonMap(name, position);
    }

    private void checkCarNameUnderRule(String name) {
        if (name.length() < CAR_NAME_MIN) {
            throw new IllegalArgumentException("자동차 이름은 최소 1자여야 합니다.");
        }
    }

    private void checkCarNameOverRule(String name) {
        if (name.length() > CAR_NAME_MAX) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자여야 합니다.");
        }
    }

    private void checkCarNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
    }
}
