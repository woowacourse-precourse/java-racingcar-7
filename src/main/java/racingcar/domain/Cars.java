package racingcar.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import racingcar.commander.MovementCommander;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String value) {
        return new Cars(cars(split(value)));
    }

    private static String[] split(String value) {
        return value.split(",");
    }

    private static List<Car> cars(String[] names) {
        return Arrays.stream(names).map(Car::new).toList();
    }

    public Cars move(MovementCommander movementCommander) {
        return new Cars(moveAll(movementCommander));
    }

    private List<Car> moveAll(MovementCommander movementCommander) {
        return this.cars.stream().map(car -> car.move(movementCommander)).toList();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
