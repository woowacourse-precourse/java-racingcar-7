package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RoundRaceRecord;
import racingcar.model.car.Car;

@DisplayName("자동차 경주 기록자 테스트")
class CarRaceRecorderTest {

    @Test
    @DisplayName("현재 자동차의 이름과 위치를 반환할 수 있다.")
    void should_RecordRoundRaceRecords_When_CarsAreProvided() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        List<Car> cars = List.of(car1, car2);

        CarRaceRecorder raceRecorder = new CarRaceRecorder();
        List<RoundRaceRecord> results = raceRecorder.recordRound(cars);

        assertThat(results).hasSize(2);
        assertThat(results.get(0)).isEqualTo(new RoundRaceRecord("pobi", 0));
        assertThat(results.get(1)).isEqualTo(new RoundRaceRecord("woni", 0));
    }

    @Test
    @DisplayName("우승한 자동차의 이름 목록을 반환할 수 있다.")
    void should_RecordRoundRaceRecords_When_CarsAreProvided2() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        List<Car> cars = List.of(car1, car2);

        CarRaceRecorder raceRecorder = new CarRaceRecorder();
        List<String> results = raceRecorder.getWinnerCarNames(cars);

        assertThat(results).hasSize(2);
        assertThat(results.get(0)).isEqualTo("pobi");
        assertThat(results.get(1)).isEqualTo("woni");
    }
}
