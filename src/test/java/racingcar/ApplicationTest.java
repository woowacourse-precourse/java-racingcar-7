package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Input.MoveCountInput;
import racingcar.Input.NameInput;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private MoveCountInput moveCountInput;

    @BeforeEach
    void setUp() {
        moveCountInput = new MoveCountInput();
        nameInput = new NameInput();
    }

    @Test
    void 입력값을_받고_MoveCount로_설정_테스트() {
        int testMoveCount = 5;

        moveCountInput.getInput(testMoveCount);

        assertEquals(testMoveCount, moveCountInput.getMoveCount(),
            "The move count should match the input value.");
    }

    private NameInput nameInput;

    @Test
    void 유효한_이름_정상_입력_테스트() {
        String input = "pobi,woni,crong";

        assertTrue(nameInput.validateInput(input),
            "모든 입력이 정상 입력");
    }

    @Test
    void 하나_이상의_이름이_5글자_초과_예외() {
        String input = "pobi,woni,crongname";

        assertFalse(nameInput.validateInput(input),
            "글자 하나 이상이 5글자 초과");
    }


}
