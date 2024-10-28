package racingcar.constant;

public enum Integers {
    // for racingcar
    CAR_NAME_MAX_LENGTH(5),
    //for record
    GO_MORE_THAN_THIS(4),
    ;

    private final int number;

    Integers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
