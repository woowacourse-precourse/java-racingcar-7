package racingcar.domain;

import java.util.List;

import static racingcar.validator.CarCountValidator.validateCarCount;

public class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    /* 기본 생성자 */
    public static Cars createFromCarNames(final List<String> carNames) {
        validateCarCount(carNames.size());
        List<Car> cars = convertToCars(carNames);
        return new Cars(cars);
    }

    /* 자동차 움직임 테스트에 사용되는 생성자
       List<Car> 형식으로 생성하여 테스트 하기 위함 */
    public static Cars createFromCarsList(final List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        cars.forEach(Car::move);
    }

    private static List<Car> convertToCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
