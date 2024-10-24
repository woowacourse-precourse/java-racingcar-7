package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Cars target = (Cars) object;

        for (int i = 0; i < target.cars.size(); i++) {
            String thisName = this.cars.get(i).name;
            String targetName = target.cars.get(i).name;
            if (thisName.equals(targetName)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
