package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // 기본 테스트
    @Test
    void basic_test() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    // 자동차 하나만 입력했을 때
    @Test
    void only_one_car() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "3");
                    assertThat(output()).contains("pobi : --", "최종 우승자 : pobi");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    // 자동차 하나만 입력하고 이동 횟수를 0으로 주었을 때
    @Test
    void moving_count_is_zero_with_one_car() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "0");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }

    // 자동차 여러개를 입력하고 이동 횟수를 0으로 주었을 때
    @Test
    void moving_count_is_zero_with_multiple_car() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,java,jane", "0");
                    assertThat(output()).contains("최종 우승자 : pobi, java, jane");
                },
                MOVING_FORWARD
        );
    }

    // 자동차 이름 입력에서의 trimming(앞 뒤 공백 제거) 테스트
    @Test
    void name_trimming_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, java ,       jane", "3");
                    assertThat(output()).contains("최종 우승자 : pobi, java, jane");
                },
                MOVING_FORWARD, STOP, STOP,
                STOP, MOVING_FORWARD, STOP,
                STOP, STOP, MOVING_FORWARD
        );
    }

    // [오류] 6글자의 자동차 이름이 입력되었을 때
    @Test
    void Error_more_than_5_word() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 이동 횟수에 음수가 입력되었을 때
    @Test
    void Error_negative_number() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 쉼표 이외의 잘못된 구분자가 입력되었을 때
    @Test
    void Error_wrong_divider() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.java;jane", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 중복된 자동차 이름이 입력되었을 때
    @Test
    void Error_duplicated_car_name() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, pobi, jane", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 정수 허용 범위 이상의 수가 이동 횟수로 입력되었을 때
    @Test
    void Error_more_than_integer() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, java, jane", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // [오류] 빈 문자열을 입력하였을 때
    @Test
    void Error_input_blank_in_name_list() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
