package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest extends NsTest {
    private final InputHandler inputHandler = new InputHandler();
    private static final String CAR_LONG_NAME = "carNameLenExceed";
    private static final String CAR_EMPTY_NAME = "";
    private static final int NEGATIVE_MOVE_COUNT = -1;
    private static final String INVALID_MOVE_COUNT = "three";

    @Test
    void 자동차_이름_길이_초과_예외() {
        assertSimpleTest(() -> {
            String[] carNames = {CAR_LONG_NAME, "car"};
            assertThatThrownBy(() -> inputHandler.validCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 자동차_이름_빈_문자열_예외() {
        assertSimpleTest(() -> {
            String[] carNames = {CAR_EMPTY_NAME, "car"};
            assertThatThrownBy(() -> inputHandler.validCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 자동차_이름_정상_입력() {
        assertSimpleTest(() -> {
            String[] carNames = {"car1", "car2", "car3"};
            inputHandler.validCarNames(carNames);
            inputHandler.validMoveCnt(5);
        });
    }

    @Override
    public void runMain() {
        // 메인 메소드가 필요 없는 경우 빈 상태로 둔다
    }
}