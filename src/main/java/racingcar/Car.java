package racingcar;

import java.util.Objects;
import racingcar.accelerator.Accelerator;

public class Car {

    private String name;
    private int mileage;
    private final Accelerator accelerator;

    Car(String name, Accelerator accelerator) {
        validateName(name);
        this.name = name;
        this.mileage = 0;
        this.accelerator = accelerator;
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    /*
     * Randoms.pickNumberInRange 값에 대한 mocking을 할 수 없기 때문에 테스트만을 위해 setter를 열어둔다.
     * */
    public void setMileageForTest(int mileage) {
        this.mileage = mileage;
    }

    public static void validateName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void accelerate() {
        int ACCELERATION_THRESHOLD = 4;
        mileage += accelerator.accelerate(ACCELERATION_THRESHOLD);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return mileage == car.mileage && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mileage);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(mileage));
    }
}
