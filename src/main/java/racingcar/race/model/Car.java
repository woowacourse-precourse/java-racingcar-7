package racingcar.race.model;

import static racingcar.race.model.Constraint.FORWARD_CONDITION_THRESHOLD;
import static racingcar.race.model.Constraint.NAME_RULE_ERROR_MESSAGE;
import static racingcar.race.model.Constraint.NAME_RULE_LENGTH;
import static racingcar.race.model.Constraint.PROGRESS_EXPRESSION;
import static racingcar.race.model.Constraint.PROGRESS_FORMAT;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location;

    Car(String name) {
        validateName(name);
        this.name = name;
        this.location = 0;
    }

    void move() {
        boolean canForward = Randoms.pickNumberInRange(0, 9) >= FORWARD_CONDITION_THRESHOLD;
        if (canForward) {
            this.location++;
        }
    }

    String getProgress() {
        return String.format(PROGRESS_FORMAT,
                this.name,
                PROGRESS_EXPRESSION.repeat(this.location));
    }

    String getName() {
        return name;
    }

    int getLocation() {
        return location;
    }

    boolean isSameLocation(int location) {
        return this.location == location;
    }

    private void validateName(String name) {
        if (name.length() >= NAME_RULE_LENGTH) {
            throw new IllegalArgumentException(NAME_RULE_ERROR_MESSAGE);
        }
    }
}
