package racingcar.car;

public class Distance {
    private final static int ZERO = 0;
    private final int value;

    private Distance(int value) {
        this.value = value;
    }

    public static Distance of(int value) {
        return new Distance(value);
    }

    public static Distance zero() {
        return new Distance(ZERO);
    }

    public Distance add(Distance anotherDistance) {
        return new Distance(this.value + anotherDistance.getValue());
    }

    public int getValue() {
        return this.value;
    }


}
