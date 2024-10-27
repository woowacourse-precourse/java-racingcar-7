package racingcar.race.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final static String NAME_RULE_ERROR_MESSAGE = "6자 이상 이름은 허용하지 않습니다.";
    private final static int NAME_RULE_LENGTH = 6;
    private static final String PROGRESS_EXPRESSION = "-";
    private static final String PROGRESS_FORMAT = "%s : %s \n";
    private static final int THRESHOLD = 4;

    private final String name;
    private int position;

    Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    void move() {
        boolean canForward = Randoms.pickNumberInRange(0, 9) >= THRESHOLD;
        if (canForward) {
            this.position++;
        }
    }

    private void validateName(String name) {
        if (name.length() >= NAME_RULE_LENGTH) {
            throw new IllegalArgumentException(NAME_RULE_ERROR_MESSAGE);
        }
    }

    public String getProgress() {
        return String.format(PROGRESS_FORMAT, this.name, PROGRESS_EXPRESSION.repeat(this.position));
    }
}
