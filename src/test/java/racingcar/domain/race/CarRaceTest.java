package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;
import racingcar.domain.move.MoveDecider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {
    private static final MoveDecider ALWAYS_MOVE = ()->true;
    private static final MoveDecider NEVER_MOVE = ()->false;
    private static final Car DUMMY_CAR = new Car(CarName.of("dummy"), CarPosition.of(0));


    @Test
    @DisplayName("MoveDecider의 canMove()가 true일시 전진하는지 확인")
    void testUpdateMove() {
        Car expected = DUMMY_CAR.moveForward();
        RacePosition racePosition = new RacePosition(List.of(DUMMY_CAR));
        CarRace carRace = new CarRace(ALWAYS_MOVE);
        RacePosition afterExecution = carRace.update(racePosition);

        Car actual = afterExecution.findByCarName(expected.getName());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("MoveDecider의 canMove()가 false일 시 전지하지 않는지 확인")
    void testUpdateNotMove() {
        Car expected = DUMMY_CAR;
        RacePosition racePosition = new RacePosition(List.of(DUMMY_CAR));
        CarRace carRace = new CarRace(NEVER_MOVE);
        RacePosition afterExecution = carRace.update(racePosition);

        Car actual = afterExecution.findByCarName(expected.getName());

        assertThat(actual).isEqualTo(expected);
    }
}