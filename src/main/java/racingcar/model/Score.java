package racingcar.model;

public class Score {
    private int value = 0;

    public int increase() {
        return ++value;
    }

    public int getValue() {
        return value;
    }
}