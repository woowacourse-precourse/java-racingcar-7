package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.RandomMoveStrategy;

public class RandomMoveStrategyTest {
    private RandomMoveStrategy randomMoveStrategy;

    @BeforeEach
    void setUp() {
        randomMoveStrategy = new RandomMoveStrategy();
    }

    @Test
    @DisplayName("랜덤 숫자가 0에서 9 사이의 값인지 확인합니다.")
    void generateRandomNumberTest() {
        // when
        int randomNumber = randomMoveStrategy.generateRandomNumber();

        // then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("이동 가능 여부 테스트 - 경계값 분석")
    void isMovableTest() {
        // given
        int thresholdNumber = 4;
        int belowThreshold = 3;
        int aboveThreshold = 5;

        // when & then
        assertAll(
                () -> assertThat(randomMoveStrategy.isMovable(thresholdNumber)).isTrue(),
                () -> assertThat(randomMoveStrategy.isMovable(belowThreshold)).isFalse(),
                () -> assertThat(randomMoveStrategy.isMovable(aboveThreshold)).isTrue()
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4 미만의 숫자에 대해 이동 불가능 테스트")
    void isNotMovableTest(int number) {
        assertThat(randomMoveStrategy.isMovable(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상의 숫자에 대해 이동 가능 테스트")
    void isMovableParameterizedTest(int number) {
        assertThat(randomMoveStrategy.isMovable(number)).isTrue();
    }
}
