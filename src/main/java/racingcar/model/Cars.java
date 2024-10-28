package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int CAR_MAX_SCOPE = 100;
    private static final int CAR_FORWARD_CONDITION = 4;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateExistCarInList(cars);
        validateCarListLessThenMaxLength(cars);
        validateSameNameIn(cars);

        this.cars = cars;
    }

    public List<String> findWinners() {
        int maxLocation = findMaxLocation();
        List<String> winnersName = new ArrayList<>();
        for (Car car : cars) {
            if (maxLocation == car.location()) {
                winnersName.add(car.name());
            }
        }
        return winnersName;
    }

    public void forwardWithRandomCondition() {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= CAR_FORWARD_CONDITION) {
                car.forward();
            }
        }
    }

    private int findMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.location(), maxLocation);
        }
        return maxLocation;
    }

    private void validateSameNameIn(List<Car> cars) {
        long distinctSize = cars.stream()
                .map(Car::name)
                .distinct()
                .count();

        if (distinctSize != cars.size()) {
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
        }
    }

    private void validateCarListLessThenMaxLength(List<Car> cars) {
        if (cars.size() > CAR_MAX_SCOPE) {
            throw new IllegalArgumentException("자동차는 최대 " + CAR_MAX_SCOPE + "개까지 입력 가능합니다.");
        }
    }

    private void validateExistCarInList(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 없습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
