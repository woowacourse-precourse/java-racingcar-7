package racingcar.model;

import java.util.List;

/**
 * 자동차 레이스 실행 결과를 저장한 클래스
 */
public class Winner {

    private final List<String> winner;

    private Winner(List<String> winner) {
        this.winner = winner;
    }

    public static Winner getFromCars(Cars cars) {
        return new Winner(cars.getMaxProgressCarsName());
    }

    @Override
    public String toString() {
        return String.join(", ", winner);
    }
}
