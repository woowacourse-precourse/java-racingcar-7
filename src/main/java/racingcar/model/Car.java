package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    public List<String> getStatus() {
        return new ArrayList<>(Arrays.asList(this.name, this.mileage.toString()));
    }

    public boolean isSameMileage(Car car) {
        return this.mileage.equals(car.mileage);
    }

    public Long getMileage() {
        return mileage;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Car compareCar = (Car) o;
        return this.mileage.compareTo(compareCar.mileage);
    }
}
