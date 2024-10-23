package racingcar.domain;

public class Position {

    private int value;

    public Position() {
        this.value = 0;
    }

    public void increasing() {
        this.value++;
    }

    public int getValue() {
        return this.value;
    }

}
