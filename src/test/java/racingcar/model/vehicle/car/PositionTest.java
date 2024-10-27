package racingcar.model.vehicle.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.modle.vehicle.car.Name;
import racingcar.modle.vehicle.car.Position;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        this.position = new Position(1);
    }

    @Test
    @DisplayName("위치 테스트")
    void getPositionTest() {
        //given
        int expected = 1;
        //when
        int actual = position.getPosition();
        //then
        assertThat(expected).isEqualTo(actual);
    }
}
