package racingcar.model.primitive;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @DisplayName("position 객체를 생성한다.")
    @Test
    void create() {
        //given //when
        Position position = Position.from(0);

        //then
        assertThat(position).isEqualTo(Position.from(0));
    }

    @DisplayName("position이 음수라면 예외를 발생한다.")
    @Test
    void positionIsNegative() {
        //given
        int position = -1;

        //when //then
        assertThatThrownBy(() -> Position.from(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("position이 음수가 아니라면 예외를 발생하지 않는다.")
    @Test
    void positionIsNotNegative() {
        //given
        int position = 0;

        //when //then
        assertThatCode(() -> Position.from(position))
                .doesNotThrowAnyException();
    }

    @DisplayName("position을 1만큼 증가할 수 있다.")
    @Test
    void move() {
        //given
        Position position = Position.from(0);

        //when
        position.move();

        //then
        assertThat(position).isEqualTo(Position.from(1));
    }

    @DisplayName("주어진 position과 현재 position을 비교하여 더 큰 position을 반환한다.")
    @Test
    void calculateMaxPosition() {
        //given
        int maxPosition = 2;
        int presentPosition = 3;
        Position position = Position.from(presentPosition);

        //when
        int result = position.calculateMaxPosition(maxPosition);

        //then
        assertThat(result).isEqualTo(presentPosition);
    }

    @DisplayName("주어진 최대 position과 현재 position을 비교하여 참, 거짓을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, true", "2, false"})
    void isMaxPosition(int maxPosition, boolean expectedValue) {
        //given
        int presentPosition = 3;
        Position position = Position.from(presentPosition);

        //when
        boolean result = position.isMax(maxPosition);

        //then
        assertThat(result).isEqualTo(expectedValue);
    }
}