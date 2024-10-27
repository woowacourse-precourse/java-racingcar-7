package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayCountControllerTest extends NsTest {
    private PlayCountController playCountController;

    @BeforeEach
    void setUp() {
        this.playCountController = new PlayCountController();
    }

    @Test
    @DisplayName("반복 횟수에 숫자가 아닌 것을 입력하면 예외가 발생한다")
    void playCountFormatError() {
        assertSimpleTest(() -> {
                    run("삼");
                    assertThatThrownBy(() -> playCountController.validatePlayCount())
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Test
    @DisplayName("반복 횟수에 숫자를 입력하면 예외가 발생하지 않는다")
    void playCountValidFormat() {
        assertSimpleTest(() -> {
                    run("5");
                    assertThatCode(() -> playCountController.validatePlayCount())
                            .doesNotThrowAnyException();
                }
        );
    }

    @Test
    @DisplayName("반복 횟수에 0 이하이거나 10 초과 값을 입력하면 예외가 발생한다")
    void playCountLimitError() {
        assertSimpleTest(() -> {
                    run("0");
                    assertThatThrownBy(() -> playCountController.validatePlayCount())
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Test
    @DisplayName("반복 횟수에 1에서 9사이의 숫자를 입력하면 예외가 발생하지 않는다")
    void playCountValidLimit() {
        assertSimpleTest(() -> {
                    run("5");
                    assertThatCode(() -> playCountController.validatePlayCount())
                            .doesNotThrowAnyException();
                }
        );
    }

    @Override
    protected void runMain() {

    }

}