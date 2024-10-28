package racingcar.service.race;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Engine;
import racingcar.domain.LapScore;
import racingcar.service.DemoCar;

class LapScoreServiceTest {

    private Car testCar (String carName, Long mileage) {
        return new DemoCar(
                carName
                , new Engine(1L
                ,1L)
                , mileage, 3L);
    }

    @Test
    @DisplayName("lapScore 변환 테스트")
    void lapScore() {
        String carName = "test1";
        Long mileage = 2L;

        List<Car> cars = List.of(testCar(carName, mileage));
        LapScoreService lapScoreService = new LapScoreService(cars);

        LapScore expected = new LapScore(carName, "-".repeat(mileage.intValue()));
        LapScore actual = lapScoreService.createEntryScores(cars).getFirst();

        assertEquals(expected.getCarName(), actual.getCarName());
        assertEquals(expected.getScore(), actual.getScore());
    }
}