package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        // given
        position = Position.from();
    }

    @Test
    @DisplayName("초기 위치는 빈 문자열이어야 함")
    void 초기_위치는_빈_문자열이어야_함() {
        // when
        String initialPosition = position.getPosition();

        // then
        assertThat(initialPosition).isEmpty();
    }

    @Test
    @DisplayName("forward() 호출 시 위치가 한 칸 전진함")
    void forward_호출_시_위치가_한_칸_전진함() {
        // when
        position.forward();

        // then
        assertThat(position.getDistance()).isEqualTo(1);
        assertThat(position.getPosition()).isEqualTo("-");
    }

    @Test
    @DisplayName("여러 번 forward() 호출 시 위치가 누적됨")
    void 여러_번_forward_호출_시_위치가_누적됨() {
        // when
        position.forward();
        position.forward();
        position.forward();

        // then
        assertThat(position.getDistance()).isEqualTo(3);
        assertThat(position.getPosition()).isEqualTo("---");
    }

    @Test
    @DisplayName("getDistance()가 위치의 길이를 정확히 반환함")
    void getDistance_가_위치의_길이를_정확히_반환함() {
        // given
        position.forward();
        position.forward();

        // when
        int distance = position.getDistance();

        // then
        assertThat(distance).isEqualTo(2);
    }
}