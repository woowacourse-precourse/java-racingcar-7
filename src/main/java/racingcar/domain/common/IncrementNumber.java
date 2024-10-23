package racingcar.domain.common;

public class IncrementNumber {

    private int value;

    public IncrementNumber() {
        this.value = 0;
    }

    public void increment() {
        this.value++;
    }

    public int getValue() {
        return this.value;
    }

}
