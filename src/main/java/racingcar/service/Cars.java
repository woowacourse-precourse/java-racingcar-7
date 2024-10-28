package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private int tryTime;

    // 생성자 - Car 객체 생성, cars 리스트에 추가
    public Cars(List<String> carNames, int tryTime) {
        carNames.forEach(carName -> cars.add(new Car(carName)));
        this.tryTime = tryTime;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> getCarInfo() {
        return cars.stream().collect(Collectors.toMap(Car::getName, Car::getScore));
    }

    // cars 리스트에 있는 모든 car 객체에 대해 move를 호출 & 시도 횟수 1 감소
    public void moveAllCar() {
        for (Car car : cars) {
            car.move();
        }
        tryTime--;
    }

    public boolean getTryTime() {
        return tryTime == 0;
    }

    public List<String> findWinner() {
        int maxScore = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
