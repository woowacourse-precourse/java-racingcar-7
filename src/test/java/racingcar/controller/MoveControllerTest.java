package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("이동 테스트")
class MoveControllerTest {
    private MoveController moveController;

    @BeforeEach
    void setUp() {
        this.moveController = new MoveController();
    }

    @Test
    @DisplayName("생성된 랜덤 숫자가 범위 내인지 확인한다")
    void checkRandomNumberRange() {
        assertThat(moveController.createRandomNumber()).isBetween(0, 9);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 전진한다")
    void isMove() {
        assertThat(moveController.isMove(4)).isTrue();
        assertThat(moveController.isMove(3)).isFalse();
    }

}