package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String names) {
        this(parse(split(names)));
    }

    public Cars(String[] names) {
        this(parse(names));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static String[] split(String names) {
        return names.split(",");
    }

    private static List<Car> parse(String[] names) {
        return  Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
