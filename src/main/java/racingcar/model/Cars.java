package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateUniqueCarNames(cars);
        validateCarCountAboveTwo(cars);
        this.cars = cars;
    }

    public static Cars from(String[] carNames) {
        return new Cars(
                Arrays.stream(carNames)
                      .map(Car::from)
                      .toList()
        );
    }

    public void advanceCarsRandomly() {
        cars.forEach(car -> car.advance(Randoms.pickNumberInRange(0, 9)));
    }

    public List<Car> findWinners() {
        int maxAdvanceCount = getMaxAdvanceCount();
        return cars.stream()
                   .filter(car -> car.getAdvanceCount() == maxAdvanceCount)
                   .toList();
    }

    public int getMaxAdvanceCount() {
        return cars.stream()
                   .mapToInt(Car::getAdvanceCount)
                   .max()
                   .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void validateUniqueCarNames(List<Car> cars) {
        Set<String> uniqueNames = new HashSet<>();

        for (Car car : cars) {
            String carName = car.getName();
            if (!uniqueNames.add(carName)) {
                throw new IllegalArgumentException("이름은 중복될 수 없습니다. 중복된 이름: " + carName);
            }
        }
    }

    public void validateCarCountAboveTwo(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("자동차 이름을 2개 이상 입력해야 합니다. (쉼표로 구분)");
        }
    }
}
