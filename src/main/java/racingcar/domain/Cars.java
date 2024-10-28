package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public List<CarDto> moveCars(){
        cars.forEach(Car::move);
        return cars.stream()
                .map(Car::toDto)
                .toList();
    }

    public List<CarDto> findWinner(){
        Car winnerCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(""));

        return cars.stream()
                .filter(winnerCar::isSamePosition)
                .map(Car::toDto)
                .toList();
    }

}
