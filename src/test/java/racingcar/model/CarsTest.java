package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.move.MoveStrategy;

class CarsTest {
    @DisplayName("자동차 이름 공백 예외")
    @Test
    void 자동차_이름_공백_예외() {
        // given
        String[] carNames = {"Car1", "", "Car3"};

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cars(carNames);
        });
        assertEquals("자동차의 이름이 올바르지 않습니다.", exception.getMessage());
    }

    @DisplayName("자동차 이름 길이 예외")
    @Test
    void 자동차_이름_길이_예외() {
        // given
        String[] carNames = {"CarOne", "CarTwo", "VeryLongCarName"};

        // when,then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cars(carNames);
        });
        assertEquals("자동차의 이름이 올바르지 않습니다.", exception.getMessage());
    }

    @DisplayName("모든 자동차 이동")
    @Test
    void 모든_자동차_이동_테스트() {
        // given
        String[] carNames = {"Car1", "Car2", "Car3"};
        MoveStrategy alwaysMoveStrategy = () -> true;
        Cars cars = new Cars(carNames);

        // 모든 자동차의 MoveStrategy를 항상 이동하는 전략으로 설정
        for (Car car : cars.getCars()) {
            car.setMoveStrategy(alwaysMoveStrategy);
        }

        // when
        cars.moveCars();

        // then
        for (Car car : cars.getCars()) {
            assertEquals(1, car.getPosition());
        }
    }

    @DisplayName("자동차 경주 우승자 탐색")
    @Test
    void 우승자_탐색() {
        // given
        String[] carNames = {"Car1", "Car2", "Car3"};
        Cars cars = new Cars(carNames);

        // 각 자동차의 위치를 설정하기 위해 MoveStrategy를 사용
        cars.getCars().get(0).setMoveStrategy(() -> true);  // Car1은 이동
        cars.getCars().get(1).setMoveStrategy(() -> false); // Car2는 이동 안 함
        cars.getCars().get(2).setMoveStrategy(() -> true);  // Car3은 이동

        // 한번 이동
        cars.moveCars();

        // when
        List<String> winners = cars.findWinner();

        // then
        assertEquals(2, winners.size()); // Car1, Car3
        assertTrue(winners.contains("Car1"));
        assertTrue(winners.contains("Car3"));
    }
}
