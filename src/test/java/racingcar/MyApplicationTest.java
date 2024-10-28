package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyApplicationTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "  "})
    @DisplayName("입력 레벨에서 잘못된 자동차이름 입력을 테스트합니다.")
    void 예외_테스트_잘못된_자동차이름_입력(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "  "})
    @DisplayName("입력 레벨에서 잘못된 시행횟수 입력을 테스트합니다.")
    void 예외_테스트_잘못된_시행횟수_입력(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java", input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"김수한무와거북이", "삼천갑자동방삭", "아아아아아아"})
    @DisplayName("자동차이름 입력을 테스트합니다.")
    void 예외_테스트_잘못된_자동차이름(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "  ", "김수한무와거북이삼천갑자동방삭", "0", "-1", "0.9", "1.5"})
    @DisplayName("잘못된 시행횟수를 테스트합니다.")
    void 예외_테스트_잘못된_시행횟수(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복 자동차의 입력을 테스트합니다.")
    void 예외_테스트_중복된_자동차() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,man", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
