package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.data.GameData;
import racingcar.dto.Car;
import racingcar.util.NumberGenerator;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRoundTest {
    private final GameData gameData = new GameData();

    @DisplayName("각 자동차가 전진하는 조건을 만족할 경우 앞으로 전진한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            // given
            Car car1 = new Car("pobi");
            Car car2 = new Car("woni");
            Car car3 = new Car("john");
            List<Car> carList = List.of(car1, car2, car3);

            NumberGenerator numberGenerator = () -> 4;

            RacingGameRound racingGameRound =
                    new RacingGameRound(carList, numberGenerator);

            // when
            racingGameRound.racing(gameData);

            // then
            for (Car car : carList) {
                assertThat(car.getMoveCount()).isEqualTo(1);
            }
        });
    }

    @DisplayName("각 자동차가 전진하는 조건을 만족하지 않을 경우 앞으로 전진하지 않는다.")
    @Test
    void test2() {
        assertSimpleTest(() -> {
            // given
            Car car1 = new Car("pobi");
            Car car2 = new Car("woni");
            Car car3 = new Car("john");
            List<Car> carList = List.of(car1, car2, car3);

            NumberGenerator numberGenerator = () -> 3;

            RacingGameRound racingGameRound =
                    new RacingGameRound(carList, numberGenerator);

            // when
            racingGameRound.racing(gameData);

            // then
            for (Car car : carList) {
                assertThat(car.getMoveCount()).isEqualTo(0);
            }
        });
    }

}