package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 이름_입력시_다섯_글자_초과_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 공백_입력_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateEmpty("   "); // 공백 문자열 입력
        });
        assertEquals("입력이 공백입니다.", exception.getMessage()); // 예외 메시지 확인
    }

    @Test
    public void 알파벳_숫자_이외_입력_테스트() {
        // 주어진 입력이 특수 문자를 포함할 때 예외가 발생하는지 테스트
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateAlphaNumeric("invalid@input!"); // 유효하지 않은 문자열 입력
        });
        assertEquals("숫자와 알파벳 외에 다른 값이 입력되었어요 : invalid@input!", exception.getMessage()); // 예외 메시지 확인
    }

    @Test
    public void 중복된_이름_테스트() {
        List<String> strings = Arrays.asList("pobi", "woni", "pobi");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateForDuplicates(strings);
        });
        assertEquals("중복된 이름입니다 : pobi", exception.getMessage()); // 예외 메시지 확인
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
