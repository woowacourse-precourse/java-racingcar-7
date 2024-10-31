package racingcar.global.dto;

import java.util.List;
import racingcar.back.domain.Car;

public record CarRaceResult(String carName, List<Integer> racePhase, Boolean isWinner) {
    // 정적 팩토리 매서드 패턴
    public static CarRaceResult fromCar(Car car) {
        return new CarRaceResult(car.getCarName(), car.getMovePhases(), car.getWinner());
    }
}
