package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    @Test
    @DisplayName("GameResult 최대 이동 횟수를 정상적으로 반환 테스트")
    void findMaxMoveCountTest() {
        Car car1 = new Car("car1", 2);
        Car car2 = new Car("car2", 5);
        Car car3 = new Car("car3", 3);
        Cars cars = new Cars(List.of(car1, car2, car3));
        GameResult gameResult = new GameResult(cars);

        Integer maxMoveCount = gameResult.findMaxMoveCount();

        assertThat(maxMoveCount).isEqualTo(5);
    }

    @Test
    @DisplayName("GameResult Cars 객체 반환 테스트")
    void getCarsTest() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Cars cars = new Cars(List.of(car1, car2));
        GameResult gameResult = new GameResult(cars);

        Cars resultCars = gameResult.getCars();

        assertThat(resultCars).isEqualTo(cars);
    }


}
