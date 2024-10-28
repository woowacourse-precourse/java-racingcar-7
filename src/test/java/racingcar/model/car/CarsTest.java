package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.race.strategy.AlwaysMoveStrategy;

@DisplayName("자동차 목록 객체 테스트")
class CarsTest {

    @Test
    @DisplayName("자동차의 이름이 규칙에 부합하는 경우 객체가 생성된다.")
    void createsCarObject_When_CarNamesAreValid() {
        List<String> testCarNames = List.of("pobi", "woni");
        Cars testCars = new Cars(testCarNames);

        List<Car> cars = testCars.getCars();
        assertEquals(testCarNames.size(), cars.size());
        assertEquals(testCarNames.get(0), cars.get(0).getName());
        assertEquals(testCarNames.get(1), cars.get(1).getName());
    }

    @Test
    @DisplayName("항상 움직이는 전략으로 모든 차를 움직이게 할 수 있다.")
    void should_MoveAllCars_When_AlwaysMoveStrategyIsUsed() {
        List<String> testCarNames = List.of("pobi", "woni");
        Cars testCars = new Cars(testCarNames);

        testCars.moveCarsIfAble(new AlwaysMoveStrategy());

        List<Car> cars = testCars.getCars();
        assertEquals(testCarNames.size(), cars.size());
        assertEquals(cars.get(0).getName(), testCarNames.get(0));
        assertEquals(cars.get(1).getName(), testCarNames.get(1));
        assertEquals(cars.get(0).getPosition(), 1);
        assertEquals(cars.get(1).getPosition(), 1);
    }
}
