package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;

public class CarService {
    private final ArrayList<Car> cars; // 자동차 목록

    public CarService() {
        this.cars = new ArrayList<>();
    }

    public void addCars(ArrayList<Car> newCars) {
        cars.addAll(newCars); // 새로운 자동차들을 기존 목록에 추가
    }
}
