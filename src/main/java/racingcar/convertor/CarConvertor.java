package racingcar.convertor;

import racingcar.dto.CarPositionDTO;
import racingcar.model.Car;

public class CarConvertor {
    public static CarPositionDTO toCarPosition(Car car) {
        return new CarPositionDTO(car.getName(), car.getPosition());
    }
}
