package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("위치가 초기값으로 생성되는지 테스트")
    void createPositionWithInitialValue() {
        // given & when
        Position position = new Position();

        // then
        assertThat(position.toInteger()).isEqualTo(0);
    }

    @Test
    @DisplayName("move 메서드로 위치가 이동하는지 테스트")
    void movePosition() {
        // given
        Position position = new Position();
        int distance = 5;

        // when
        position.move(distance);

        // then
        assertThat(position.toInteger()).isEqualTo(distance);
    }

    @Test
    @DisplayName("move 메서드로 여러번 이동하는지 테스트")
    void movePositionMultipleTimes() {
        // given
        Position position = new Position();
        int firstMove = 3;
        int secondMove = 4;

        // when
        position.move(firstMove);
        position.move(secondMove);

        // then
        assertThat(position.toInteger()).isEqualTo(firstMove + secondMove);
    }
}
