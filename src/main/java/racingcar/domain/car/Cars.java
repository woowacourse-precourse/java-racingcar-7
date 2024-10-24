package racingcar.domain.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public void accelerateSpecificCar(Car car) {
        car.accelerator();
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isAtSameOrAheadOf(maxPosition))
                .map(car -> car.getCarInfo().getName())
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getCarInfo().getCurrentPosition())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("참가자가 없습니다."));
    }

    private void validateDuplicateCarName(List<Car> cars) {
        Set<Car> setCar = new HashSet<>(cars);
        if (setCar.size() != cars.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }
}
