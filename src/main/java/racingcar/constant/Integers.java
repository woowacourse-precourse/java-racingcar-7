package racingcar.constant;

public enum Integers {
    CAR_NAME_MAX_LENGTH(5),
    ;

    private final int number;
    Integers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
