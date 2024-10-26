package racingcar.model;

public class Car implements Comparable {

    public static final int CAR_NAME_LENGTH_LIMIT = 5;
    private Long mileage = 0L;

    private String name;

    public Car(String name) {
        if (validate(name)) {
            this.name = name;
        }
    }

    public Car(String name, Long mileage) {
        if (validate(name)) {
            this.name = name;
            this.mileage = mileage;
        }
    }

    private boolean validate(String name) {
        if (name.isEmpty() || name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public void forward() {
        mileage += 1;
    }

    @Override
    public int compareTo(Object o) {
        Car compareCar = (Car) o;
        return this.mileage.compareTo(compareCar.mileage);
    }
}
