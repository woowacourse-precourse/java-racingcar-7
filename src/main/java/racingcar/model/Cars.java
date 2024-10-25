package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.dto.CarDto;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void saveCar(final String carName) {
        Car car = new Car(carName);
        cars.add(car);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<CarDto> getCarDtoList() {
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : cars) {
            CarDto carDto = CarDto.from(car);
            carDtoList.add(carDto);
        }
        return carDtoList;
    }

    public List<Car> calculateFarthestCars() {
        List<Car> farthestCars = new ArrayList<>();
        long maxPosition = Collections.max(cars).getPosition();
        for (Car car : cars) {
            long carPosition = car.getPosition();
            if (carPosition == maxPosition) {
                farthestCars.add(car);
            }
        }
        return farthestCars;
    }
}
