package racingcar.model.dto;

import racingcar.model.entity.Cars;

import java.util.List;

/**
 * 자동차 경주 우승자 정보를 담아서 전달하는 객체
 */
public record RacingWinners(List<String> winner) {

    public static RacingWinners getFromCars(Cars cars) {
        return new RacingWinners(cars.getMaxProgressCarsName());
    }

    @Override
    public String toString() {
        return String.join(", ", winner);
    }

}
