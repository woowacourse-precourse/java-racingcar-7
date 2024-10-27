package racingcar;

import racingcar.observer.CarObserver;
import racingcar.observer.CarObserverHelper;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        this.cars = cars.stream()
                .map(Car::new)
                .toList();
    }

    public void moveAll(List<Integer> randomValues) {
        if (randomValues.size() != cars.size()) {
            throw new IllegalStateException("랜덤 값의 개수와 자동차 개수가 일치하지 않습니다.");
        }

        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomValues.get(i));
        }
    }

    public void addObserverToAll(Class<? extends CarObserver> observerClass, Object... dependencies) {
        for (Car car : cars) {
            CarObserverHelper.addObserverToCar(car, observerClass, dependencies);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    public int size() {
        return cars.size();
    }

}