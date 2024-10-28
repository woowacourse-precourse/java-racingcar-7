package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RacingControllerTest {
    @Test
    void 유효하지_않은_이름_예외_테스트() {
        RacingController controller = new RacingController();
        assertThatThrownBy(() -> controller.isValidName("testwrongname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 자동차 이름 입니다.");
    }

    @Test
    void 유효한_이름_검증() {
        RacingController controller = new RacingController();
        boolean isValid = controller.isValidName("test");
        assertThat(isValid).isTrue();
    }

    @Test
    void 유효하지_않은_시도횟수_예외_테스트() {
        RacingController controller = new RacingController();
        assertThatThrownBy(() -> controller.parseCount("@"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 시도 횟수 입니다.");
    }
}
