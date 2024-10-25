package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import utility.Input;

public class InputTest extends NsTest {
    // 기능 케이스
    private static final String[][] TEST_SET_INPUT_CARS_O = {
            {"a, bc, def, , ghij", "7"}, // 중간에 공백
            {"a, bc, def, 나는자동차", "7"}, // 알파벳 아닌 언어(한글)
            {"a, 金永, def, ghij", "7"}, // 알파벳 아닌 언어(한자)
            {"a9, bc6, def, ghij8", "7"}, // 숫자
            {"luc 7, gene6, , 朱on, 우테코7", "7"}, // 언어,숫자,공백 모두 포함
    };
    private static final String[][] TEST_SET_INPUT_NUMTRY_O = {
            {"a11, b22, c33, , d44", "1"},
            {"a11, b22, c33, , d44", "2"},
            {"a11, b22, c33, , d44", "10"}
    };
    // 예외 케이스
    private static final String[][] TEST_SET_INPUT_CARS_X = {
            {"", "7"}, // 공백
            {"abc, defgh, HiHello", "7"}, // 5글자 초과
            {"a, 金永, L&U, name:", "7"}, // 구분자로 쉼표(,) 이외의 문자 입력
    };
    private static final String[][] TEST_SET_INPUT_NUMTRY_X = {
            {"a11, b22, c33, , d44", "a"}, // 문자
            {"a11, b22, c33, , d44", "2.5"}, // 실수
            {"a11, b22, c33, , d44", "-3"}, // 음수
            {"a11, b22, c33, , d44", "0"} // 0
    };

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void inputCarsTestO(int idx) {
        assertSimpleTest(() -> {
            run(TEST_SET_INPUT_CARS_O[idx]);
            assertThat(output()).contains("Successful: 자동차 이름");
        });
    }

    // 자동차 이름 : 예외 테스트
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void inputCarTestX(int idx) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(TEST_SET_INPUT_CARS_X[idx]))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 시도 횟수 : 기능 테스트
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void inputNumTryO(int idx) {
        assertSimpleTest(() -> {
            run(TEST_SET_INPUT_NUMTRY_O[idx]);
            assertThat(output()).contains("Successful: 시도 횟수");
        });
    }

    // 시도 횟수 : 예외 테스트
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void inputNumTryX(int idx) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(TEST_SET_INPUT_NUMTRY_X[idx]))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // Main
    @Override
    public void runMain() {
        Input.test(new String[]{});
    }
}
