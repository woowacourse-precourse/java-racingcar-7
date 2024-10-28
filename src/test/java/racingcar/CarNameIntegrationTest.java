package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.argumentresolver.CarArgumentResolver;

public class CarNameIntegrationTest {

    private CarArgumentResolver argumentResolver = new CarArgumentResolver();
    private SizeValidator validator = new SizeValidator();


    static final Integer MIN_LENGTH = 0;
    static final Integer MAX_LENGTH = 5;
    static final String ERROR_MESSAGE_VALIDATOR = "%d자 초과, %d자 이하만 가능합니다.";
    static final String ERROR_MESSAGE_RESOLVER = "비어있는 입력은 불가능합니다.";

    @Test
    @DisplayName("비어있을 경우 argumentResolver 에 의해 에러 발생")
    void 비어있는_입력_테스트() {
        // given
        String whiteSpaceInput = " ";
        String emptyInput = "";
        String nullInput = null;

        // when & then
        whenSplitToArgumentResolverThenException(whiteSpaceInput);
        whenSplitToArgumentResolverThenException(emptyInput);
        whenSplitToArgumentResolverThenException(nullInput);
    }

    @Test
    @DisplayName("구분자가 앞뒤로 있거나 연속해서 오면 validator 에 의해 에러 발생")
    void 구분자_예외_테스트() {
        // given
        List<String> errorInput = List.of(
                ",",
                "a,",
                ",a",
                ",a,",
                "a,,b"
        );

        List<List<String>> afterSplit = errorInput.stream()
                .map((i) -> argumentResolver.parse(i))
                .toList();

        // when & then
        for (List<String> names : afterSplit) {
            whenCheckToValidatorAndThenException(names);
        }
    }

    private void whenSplitToArgumentResolverThenException(String input) {
        assertThatThrownBy(() -> argumentResolver.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_RESOLVER);
    }

    private void whenCheckToValidatorAndThenException(List<String> rawCarNames) {
        assertThatThrownBy(() -> validator.check(rawCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ERROR_MESSAGE_VALIDATOR, MIN_LENGTH, MAX_LENGTH));
    }

}
