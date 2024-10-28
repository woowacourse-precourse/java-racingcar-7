package racingcar.domain.car;

import java.util.List;

public class Cars {

    private final List<Vehicle> values;

    private Cars(List<Vehicle> values) {
        this.values = values;
    }

    public static Cars from(List<Vehicle> values) {
        return new Cars(values);
    }

    public List<Vehicle> getValues() {
        return values;
    }
}
