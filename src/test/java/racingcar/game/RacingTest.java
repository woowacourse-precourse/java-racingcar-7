package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    @DisplayName("우승자 검증")
    @Test
    void validateWinner() {
        // given
        List<Car> cars = CarFactory.createCars("pobi,woni,jun");
        Racing racing = new Racing(cars, 5);

        // when
        racing.start();

        // then
        List<Car> winners = racing.getWinners();

        // winner 위치가 서로 같아야 함
        int winnerPosition = winners.get(0).getPosition();
        for (Car car : winners) {
            assertEquals(winnerPosition, car.getPosition());
        }

        // winner를 제외한 나머지 차량은 winner보다 위치가 작아야 함
        for (Car car : cars) {
            if (winners.contains(car)) {
                continue;
            }
            assertTrue(car.getPosition() < winnerPosition);
        }

    }
}
