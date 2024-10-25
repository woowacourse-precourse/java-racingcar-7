package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveCommandTest {

    private Cars cars;
    private TestMoveStrategy moveStrategy;
    private MoveCommand moveCommand;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("pobi", "jun", "kiki"));
        moveStrategy = new TestMoveStrategy();
        moveCommand = new MoveCommand(moveStrategy);
    }

    @Test
    @DisplayName("자동차가 명령을 정상적으로 수행한다.")
    void moveCars() {
        moveCommand.command(cars);

        Map<String, Integer> positions = cars.getCarPositions();

        assertEquals(1, positions.get("pobi"));
        assertEquals(1, positions.get("jun"));
        assertEquals(1, positions.get("kiki"));
    }

    @Test
    @DisplayName("규칙에 맞지 않는 자동차는 이동하지 않는다.")
    void notMoveCars() {
        moveStrategy = new TestMoveStrategy(false);
        moveCommand = new MoveCommand(moveStrategy);

        moveCommand.command(cars);

        Map<String, Integer> positions = cars.getCarPositions();

        assertEquals(0, positions.get("pobi"));
        assertEquals(0, positions.get("jun"));
        assertEquals(0, positions.get("kiki"));
    }

}
