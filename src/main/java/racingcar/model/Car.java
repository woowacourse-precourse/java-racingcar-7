package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

public class Car {

    private static final int INCREMENT_VALUE = 1;
    private static final int DEFAULT_POSITION = 0;
    private static final int NAME_MAX_LENGTH = 5;
    private int position = DEFAULT_POSITION;
    private final String name;

    public Car(String name) {
        this.name = name;
        validateNameValue(name);
        validateNameLength(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void increasePosition() {
        position += INCREMENT_VALUE;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자를 넘을 수 없습니다.");
        }
    }
    private void validateNameValue(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
    }
}
