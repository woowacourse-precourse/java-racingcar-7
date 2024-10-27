package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @DisplayName("위치를 이동한다.")
    @Test
    void move() {
        //given
        Position position = new Position(0);

        //when
        Position result = position.move();

        //then
        assertThat(result).isEqualTo(new Position(1));
    }

    @DisplayName("위치를 비교할 수 있다.")
    @CsvSource({
            "0, 1, -1",
            "4, 3, 1",
            "3, 3, 0",
    })
    @ParameterizedTest
    void compareTo(int number1, int number2, int expected) {
        //given
        Position position1 = new Position(number1);
        Position position2 = new Position(number2);

        //when
        int result = position1.compareTo(position2);

        //then
        assertThat(result).isEqualTo(expected);
    }
}