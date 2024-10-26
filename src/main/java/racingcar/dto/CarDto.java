package racingcar.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;

public class CarDto {
    private final Map<String, Integer> carDto;

    public CarDto(Map<String, Integer> carDto) {
        this.carDto = carDto;
    }

    public static CarDto of(List<Car> cars) {
        Map<String, Integer> carDto = new LinkedHashMap<>();
        for (Car car : cars) {
            carDto.put(car.getCarName(), car.getCarDistance());
        }
        return new CarDto(carDto);
    }

    public Map<String, Integer> getCarDto() {
        return carDto;
    }
}
