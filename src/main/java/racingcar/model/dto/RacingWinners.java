package racingcar.model.dto;

import racingcar.model.entity.CarsByNames;

import java.util.List;

/** 자동차 경주 우승자 정보를 담아서 전달하는 DTO */
public record RacingWinners(List<String> winner) {

    public static RacingWinners getFromCars(CarsByNames carsByNames) {
        return new RacingWinners(carsByNames.getMaxProgressCarsName());
    }

    @Override
    public String toString() {
        return String.join(", ", winner);
    }

}
