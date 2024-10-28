package racingcar.model.entity;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * 자동차를 구현한 클래스, 움직이는 것은 전략 클래스에 위임한다.
 */
public class Car {

    private final String name;

    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public void moveBy(Supplier<Integer> strategy) {
        this.progress += strategy.get();
    }

    public int getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(this.name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
