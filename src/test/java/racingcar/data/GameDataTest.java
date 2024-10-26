package racingcar.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class GameDataTest {
    private final GameData gameData = new GameData();

    @DisplayName("각 자동차가 얼마나 전진했는지 기록한다")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            // given
            Car car1 = new Car("pobi", 1);
            Car car2 = new Car("woni", 3);
            Car car3 = new Car("john", 2);
            List<Car> carList = List.of(car1, car2, car3);

            // when
            gameData.save(carList);
            List<RoundData> roundData = gameData.getRoundData();
            RoundData first = roundData.getFirst();
            List<Car> result = first.getResult();

            // then
            for (int i = 0; i < result.size(); i++) {
                Assertions.assertThat(result.get(i).getMoveCount()).isEqualTo(carList.get(i).getMoveCount());
            }
        });
    }

}