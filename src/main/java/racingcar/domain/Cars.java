package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
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
        this(makeCars(carNameList));
    }

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.replace(SPACE, NO_SPACE).split(DELIMITER);
    }

    private static List<Car> makeCars(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveCar(Randoms.pickNumberInRange(0, 9));
        }
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.max(maxDistance);
        }
        return maxDistance;
    }

    public WinnerCars getWinnerCars(int maxDistance) {
        WinnerCars winnerCars = new WinnerCars();
        for (Car car : cars) {
            winnerCars.addWinner(car, maxDistance);
        }
        return winnerCars;
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

