package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class GameControllerTest {

    @Test
    @DisplayName("우승자 결정 테스트 - 모든 자동차가 같은 위치에 도달")
    void determineWinnersWithSamePosition() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        MoveStrategy alwaysMoveStrategy = () -> true; // 항상 이동하는 전략
        GameController gameController = new GameController(cars, alwaysMoveStrategy);
        gameController.startRace(5);

        List<String> winners = gameController.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun"); // 모든 자동차가 공동 우승
    }

    @Test
    @DisplayName("우승자 결정 테스트 - 일부 자동차만 전진")
    void determineWinnersWithDifferentPositions() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        List<Car> cars = List.of(car1, car2, car3);

        // 특정 자동차만 이동하는 전략 설정 (예: car1만 이동)
        MoveStrategy moveStrategy = new MoveStrategy() {
            private int count = 0;

            @Override
            public boolean canMove() {
                return count++ % 3 == 0; // 첫 번째 자동차만 이동하도록 설정
            }
        };

        GameController gameController = new GameController(cars, moveStrategy);
        gameController.startRace(5);

        List<String> winners = gameController.getWinners();
        assertThat(winners).containsExactly("pobi");
    }
}