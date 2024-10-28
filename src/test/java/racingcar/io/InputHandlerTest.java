package racingcar.io;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputHandlerTest extends NsTest {

    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();  // 테스트마다 InputHandler 인스턴스 초기화
    }

    @Test
    void 자동차_이름이_빈값일_때_예외가_발생한다() {
        assertSimpleTest(() -> {
            run(",자동차2,자동차3");
            assertThatThrownBy(inputHandler::getCarNames)
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 자동차_이름이_5자를_초과할_때_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("자동차1,길이초과이름,자동차3");
            assertThatThrownBy(inputHandler::getCarNames)
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도_횟수가_자연수가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            run("0");
            assertThatThrownBy(inputHandler::getTrialCount)
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 올바른_시도_횟수는_정상적으로_반환된다() {
        run("5");
        int trialCount = inputHandler.getTrialCount();

        assertThat(trialCount).isEqualTo(5);
    }

    @Override
    public void runMain() {}
}
