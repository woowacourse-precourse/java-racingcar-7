
package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_FORWARD_BOUND = 4;

    private final NumberSupplier numberSupplier;
    private final String name;
    private int position;

    public Car(String name, NumberSupplier numberSupplier) {
        validate(name);

        this.numberSupplier = numberSupplier;
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public Car(String name) {
        this(name, new RandomNumberSupplier());
    }

    private void validate(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하이어야 합니다");
        }
    }

    public void move() {
        if (numberSupplier.supply() >= MOVE_FORWARD_BOUND) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
