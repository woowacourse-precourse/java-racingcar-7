package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @Test
    @DisplayName("우승자를 올바르게 선정한다")
    void determineWinners() {
        // given
        List<Car> cars = Arrays.asList(
                createCarWithPosition("pobi", 3),
                createCarWithPosition("woni", 1),
                createCarWithPosition("jun", 3)
        );
        RacingGame game = new RacingGame(cars);

        // when
        List<String> winners = game.getWinners();

        // then
        assertEquals(Arrays.asList("pobi", "jun"), winners);
    }

    private Car createCarWithPosition(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.move(4); // 4 이상이면 전진
        }
        return car;
    }

    @Test
    @DisplayName("라운드 결과를 올바르게 반환한다")
    void getRoundResults() {
        // given
        List<Car> cars = Arrays.asList(
                createCarWithPosition("pobi", 2),
                createCarWithPosition("woni", 1)
        );
        RacingGame game = new RacingGame(cars);

        // when
        List<String> results = game.getRoundResult();

        // then
        assertEquals(Arrays.asList(
                "pobi : --",
                "woni : -"
        ), results);
    }
}
