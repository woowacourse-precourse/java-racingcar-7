package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;

import java.util.List;

public class RaceService {

    private List<Car> carList;

    public List<Car> getCarList(UserInputDTO userInputDTO) {
        return this.carList;
    }
}
