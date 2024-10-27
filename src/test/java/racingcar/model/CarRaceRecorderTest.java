package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RoundRaceRecord;

@DisplayName("자동차 경주 기록자 테스트")
class CarRaceRecorderTest {

    @Test
    @DisplayName("현재 자동차의 위치를 기록할 수 있다.")
    void should_RecordRoundRaceRecords_When_CarsAreProvided() {
        Car car1 = new Car("pobi");
        moveCarForward(car1, 3);
        Car car2 = new Car("woni");
        moveCarForward(car2, 5);
        List<Car> cars = List.of(car1, car2);

        CarRaceRecorder raceRecorder = new CarRaceRecorder();
        List<RoundRaceRecord> results = raceRecorder.recordRound(cars);

        assertThat(results).hasSize(2);
        assertThat(results.get(0)).isEqualTo(new RoundRaceRecord("pobi", 3));
        assertThat(results.get(1)).isEqualTo(new RoundRaceRecord("woni", 5));
    }

    private void moveCarForward(Car car, int repeat) {
        for (int i = 0; i < repeat; i++) {
            car.moveForward();
        }
    }
}
