package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

public class Car {

    public static final int INCREMENT_VALUE = 1;
    private final int NAME_MAX_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        validateNameValue(name);
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameValue(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException();
        }
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
}
