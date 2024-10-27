package racingcar.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class CarsNameTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"\n", " "})
    void 빈_입력_예외_테스트(String input) {
        예외_실행(input, "입력이 비어 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,a,b", "hani,kitty,kitty"})
    void 자동차_이름이_중복인_예외_테스트(String input) {
        예외_실행(input, "자동차 이름은 중복을 허용하지 않습니다.");
    }

    @Test
    void 구분자_쉼표가_아닌_예외_테스트1() {
        예외_실행("a:c:b", "이름은 기호를 포함할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"hani*kitty*kai", "hani,mice*kai"})
    void 구분자_쉼표가_아닌_예외_테스트2(String input) {
        예외_실행(input, "이름은 5자 이하로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,", "hani,,kitty"})
    void 구분자로_구분할_문자열이_없는_경우_예외_테스트(String input) {
        예외_실행(input, "비어있는 자동차 이름이 있습니다.");
    }

    void 예외_실행(String input, String errorMessage) {
        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
