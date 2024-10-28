package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 여러 대의 자동차를 관리하며 경주에서의 이동과 우승자를 판별한다.
 */
public class Cars {
    private final List<Car> cars;

    /**
     * 자동차 이름 리스트로부터 Cars 컬렉션을 생성한다.
     *
     * @param carNames 자동차 이름 리스트
     */
    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    /**
     * 모든 자동차를 이동시킨다.
     */
    public void moveAll() {
        this.cars.forEach(Car::move);
    }

    /**
     * 가장 먼 위치에 있는 자동차들을 우승자로 반환한다.
     *
     * @return 우승 자동차 리스트
     */
    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElseThrow(IllegalArgumentException::new);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
