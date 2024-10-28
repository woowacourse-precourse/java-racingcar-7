package racingcar.model;

import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.dto.CarDto;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void saveCar(final Car car) {
        validateDuplicateCarName(car);
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

    public List<String> getWinnerNames() {
        List<String> winnerNameList = new ArrayList<>();

        long farthestPosition = getFarthestPosition();

        for (Car car : cars) {

            long carPosition = car.getPosition();

            if (carPosition == farthestPosition) {
                String winnerName = car.getName();
                winnerNameList.add(winnerName);
            }
        }
        return winnerNameList;
    }

    private void validateDuplicateCarName(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.message());
        }
    }

    private long getFarthestPosition() {
        Car farthestCar = Collections.max(cars);
        return farthestCar.getPosition();
    }
}
