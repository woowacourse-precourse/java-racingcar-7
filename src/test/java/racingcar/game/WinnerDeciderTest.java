package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.data.GameData;
import racingcar.dto.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinnerDeciderTest {
    private final WinnerDecider winnerDecider = new WinnerDecider();

    @DisplayName("가장 많이 전진한 자동차를 결정한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            // given
            List<Car> carList = createCarList();

            GameData gameData = new GameData();
            gameData.save(carList);

            // when
            List<Car> winner = winnerDecider.decideWinner(gameData);

            // then
            for (Car car : winner) {
                assertThat(car.getMoveCount()).isEqualTo(3);
            }
        });
    }

    private List<Car> createCarList() {
        Car car1 = new Car("pobi", 1);
        Car car2 = new Car("woni", 3);
        Car car3 = new Car("john", 2);
        return List.of(car1, car2, car3);
    }

}