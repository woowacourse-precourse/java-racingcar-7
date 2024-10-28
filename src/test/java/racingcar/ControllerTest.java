package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller;

public class ControllerTest {

    private final Controller controller = new Controller();

    @Test
    @DisplayName("랜덤값이 4 이상일 경우 go")
    void 랜덤값이_4이상이면_전진한다() {

        Assertions.assertThat(controller.moveThreshold(8))
                .isEqualTo("go");
    }

    @Test
    @DisplayName("랜덤값이 4 미만일 경우 stop")
    void 랜덤값이_4이하이면_NO_DIRECTION을_반환한다() {
        Assertions.assertThat(controller.moveThreshold(2))
                .isEqualTo("stop");
    }

}
