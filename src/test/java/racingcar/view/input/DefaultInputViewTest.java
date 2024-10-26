package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DefaultInputViewTest {

    private final DefaultInputView defaultInputView = new DefaultInputView();

    static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of("a,b,c,d", List.of("a", "b", "c", "d")),
                Arguments.of("a,b,c,d,e", List.of("a", "b", "c", "d", "e")),
                Arguments.of("a", List.of("a")),
                Arguments.of("\n", List.of(""))
        );
    }

    static Stream<Arguments> provideTryCount() {
        return Stream.of(
                Arguments.of("5", 5),
                Arguments.of("1", 1),
                Arguments.of("7", 7)
        );
    }

    static Stream<Arguments> provideInvalidTryCount() {
        return Stream.of(
                Arguments.of("a", IllegalArgumentException.class),
                Arguments.of("1.1", IllegalArgumentException.class)
        );
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(System.in);
        Console.close();
    }

    @ParameterizedTest(name = "입력: {0}, 기대값: {1}")
    @MethodSource("provideCarNames")
    @DisplayName("getCarNames() : 자동자_이름을_입력받아_쉼표를_기준으로_분리한다")
    void 자동자_이름을_입력받아_쉼표를_기준으로_분리한다(String input, List<String> expected) {

        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = defaultInputView.getCarNames();

        // then
        assertThat(carNames).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest(name = "입력: {0}, 기대값: {1}")
    @MethodSource("provideTryCount")
    @DisplayName("getTryCount() : 시도_횟수를_입력받는다")
    void 시도_횟수를_입력받는다(String input, int expected) {

        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int tryCount = defaultInputView.getTryCount();

        // then
        assertThat(tryCount).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력: {0}, 기대 예외: {1}")
    @MethodSource("provideInvalidTryCount")
    @DisplayName("getTryCount() : 시도_횟수가_정수가_아닌_경우_예외를_던진다")
    void 시도_횟수가_정수가_아닌_경우_예외를_던진다(String input, Class<? extends RuntimeException> expected) {

        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThatThrownBy(defaultInputView::getTryCount).isInstanceOf(expected);
    }

}
