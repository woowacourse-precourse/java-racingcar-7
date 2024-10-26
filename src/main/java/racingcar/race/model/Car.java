package racingcar.race.model;

public class Car {
    private final static String NAME_RULE_ERROR_MESSAGE = "6자 이상 이름은 허용하지 않습니다.";
    private final static int NAME_RULE_LENGTH = 6;

    private final String name;
    private final int position;

    public Car(String name) {
        validName(name);
        this.name = name;
        this.position = 0;
    }

    private static void validName(String name) {
        if (name.length() >= NAME_RULE_LENGTH) {
            throw new IllegalArgumentException(NAME_RULE_ERROR_MESSAGE);
        }
    }
}
