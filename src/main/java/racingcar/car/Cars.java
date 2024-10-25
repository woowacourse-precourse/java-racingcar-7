package racingcar.car;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplicateCars(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> moves() {
        for (Car car : cars) {
            car.move();
        }

        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 에러가 발생하였습니다."));
    }

    private void validateDuplicateCars(List<String> carNames) {
        int count = (int) carNames.stream()
                .distinct()
                .count();

        if (count != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복으로 입력할 수 없습니다.");
        }
    }
}
