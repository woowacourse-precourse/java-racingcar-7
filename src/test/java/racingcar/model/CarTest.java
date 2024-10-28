package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void initializeCar() {
        car = Car.create("jiho");
    }

    @Test
    @DisplayName("차가 move(4) 호출 시, 예상된 이동 결과 문자열을 반환해야 한다")
    void shouldReturnExpectedStringWhenCarMoves() {

        // when
        String result = car.move(4);

        // then
        assertEquals("jiho : -", result);
    }

    @Test
    @DisplayName("차가 move(4) 호출 시, position 값이 1 증가해야 한다")
    void shouldIncrementPositionWhenCarMoves() {

        // when
        car.move(4);

        // then
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("차가 최대 위치에 있을 경우, topRanker 목록에 포함되어야 한다")
    void shouldIncludeCarInTopRankerAtMaxPosition() {

        // given
        car.move(4);
        List<String> topRankers = new ArrayList<>();

        // when
        car.addTopRankers(topRankers, car.getPosition());

        // then
        assertTrue(topRankers.contains("jiho"), "Expected topRankers to contain 'jiho'");
    }
}
