package exceptor;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import constant.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class ValidatorTest extends NsTest {

    @DisplayName("정상_입력_테스트")
    @Test
    void normal_input_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains(Constants.RACING_START_MESSAGE);
                },
                3
        );
    }

    @DisplayName("실수_입력_예외_테스트")
    @Test
    void float_exception_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi","1.2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("문자열_입력_예외_테스트")
    @Test
    void letter_exception_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi","abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("음수_입력_예외_테스트")
    @Test
    void negative_integer_exception_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi","-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("글자수_초과입력_예외_테스트")
    @Test
    void name_limit_exception_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobipobi,wonywony,junjun","3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("중복_입력_예외_테스트")
    @Test
    void duplicate_exception_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi","3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("중복_입력_예외_성능_테스트")
    @Test
    void duplicate_exception_runtime_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,".repeat(1000000)+"pobi","3"))
                        .isInstanceOf(IllegalArgumentException.class) // 약 200만개 이상의 배열을 처리할 때 limit 초과
        );
    }

    @DisplayName("공백_입력_예외_테스트")
    @Test
    void blank_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ","3"))
                        .isInstanceOf(IllegalArgumentException.class) // 약 200만개 이상의 배열을 처리할 때 limit 초과
        );
    }



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
