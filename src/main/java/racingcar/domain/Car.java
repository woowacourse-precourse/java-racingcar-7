
package racingcar.domain;

public class Car {

    private static final RandomNumberSupplier DEFAULT_NUMBER_SUPPLIER = new RandomNumberSupplier();
    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_FORWARD_BOUND = 4;

    private final NumberSupplier numberSupplier;
    private final String name;
    private int position;

    private Car(NumberSupplier numberSupplier, String name, int position) {
        validate(name);

        this.numberSupplier = numberSupplier;
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(DEFAULT_NUMBER_SUPPLIER, name, INITIAL_POSITION);
    }

    public Car(NumberSupplier numberSupplier, String name) {
        this(numberSupplier, name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        this(DEFAULT_NUMBER_SUPPLIER, name, position);
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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
