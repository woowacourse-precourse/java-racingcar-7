package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private final List<Car> cars;

    public Cars(String carNames) {
        this(splitCarNames(carNames));
    }

    public Cars(String[] carNameList) {
        this.cars = makeCars(carNameList);
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.replace(SPACE, NO_SPACE).split(DELIMITER);
    }

    private List<Car> makeCars(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars otherCars = (Cars) o;
        return Objects.equals(this.cars, otherCars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

