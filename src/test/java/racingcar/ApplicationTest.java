package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.game.constant.ExceptionMessage.*;

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
    void 자동차이름이_빈문자열일때_예외() {
        assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_BLANK.getMessage());
    }

    @Test
    void 자동차_개수가_11개_들어왔을때_예외() {
        assertThatThrownBy(() -> runException("pobi,jun,woni,yeonjoo,soeun,somin,chaeyoung,chaerin,seohyun,jinho,seongjin", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CAR_COUNT.getMessage());
    }

    @Test
    void 자동차이름에_공백이_포함될때_예외() {
        assertThatThrownBy(() -> runException("pobi,,jun", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_BLANK.getMessage());
    }

    @Test
    void 자동차이름이_5자를_초과할때_예외() {
        assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    void 시도횟수가_1미만일때_예외() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RACING_COUNT_RANGE.getMessage());
    }

    @Test
    void 시도횟수가_10초과할때_예외() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", "11"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RACING_COUNT_RANGE.getMessage());
    }

    @Test
    void 중복된자동차이름이_있을때_예외() {
        assertThatThrownBy(() -> runException("pobi,pobi,jun", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_CAR_NAME.getMessage());
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
