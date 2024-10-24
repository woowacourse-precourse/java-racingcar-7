package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

//    private static final int MOVING_FORWARD = 4;
//    private static final int STOP = 3;
//
//    @Test
//    void 기능_테스트() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("pobi,woni", "1");
//                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//                },
//                MOVING_FORWARD, STOP
//        );
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    // 1.1) 빈 값을 입력한 경우 (자동차 이름이 빈 값인 경우 포함)
    @Test
    void 입력이_비어있을_때_예외() {
        assertThatThrownBy(() -> Application.validateInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Application.EMPTY_INPUT_MESSAGE);

        assertThatThrownBy(() -> Application.validateInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Application.EMPTY_INPUT_MESSAGE);

        assertThatThrownBy(() -> Application.validateInput("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Application.EMPTY_INPUT_MESSAGE);
    }

    @Test
    void 자동차_이름이_비어있는_경우_예외() {
        assertThatThrownBy(() -> Application.validateInput("pobi, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Application.NAME_EMPTY_MESSAGE);

        assertThatThrownBy(() -> Application.validateInput(",pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Application.NAME_EMPTY_MESSAGE);

        assertThatThrownBy(() -> Application.validateInput(" , "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Application.NAME_EMPTY_MESSAGE);
    }

    // 1.2) , 대신 다른 구분자를 사용할 경우
    @Test
    void 쉼표가_없는_경우_예외() {
        assertThatThrownBy(() -> Application.validateInput("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Application.COMMA_REQUIRED_MESSAGE);
    }

    // 1.3) 실제 입력값이 2개 미만인 경우
    @Test
    void 자동차_이름이_하나인_경우_예외() {
        assertThatThrownBy(() -> Application.validateInput("pobi,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Application.MIN_CARS_REQUIRED_MESSAGE);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
