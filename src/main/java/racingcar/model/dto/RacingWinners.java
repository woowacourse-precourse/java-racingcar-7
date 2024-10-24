package racingcar.model.dto;

import racingcar.model.entity.Cars;

import java.util.List;

/**
 * 자동차 레이스 실행 결과를 저장한 클래스
 */
public class RacingWinners {

    private final List<String> winner;

    private RacingWinners(List<String> winner) {
        this.winner = winner;
    }

    public static RacingWinners getFromCars(Cars cars) {
        return new RacingWinners(cars.getMaxProgressCarsName());
    }

    @Override
    public String toString() {
        return String.join(", ", winner);
    }
}
