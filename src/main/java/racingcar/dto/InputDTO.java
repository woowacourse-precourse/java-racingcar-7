package racingcar.dto;

import racingcar.model.Car;

import java.util.List;

public record InputDTO(List<Car> carList, int turnCount) {

}
