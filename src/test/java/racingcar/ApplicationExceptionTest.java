package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("ApplicationException 테스트")
public class ApplicationExceptionTest extends NsTest {

    private final String validCarNamesInput = "a,b,c";

    @Test
    @DisplayName("main() : 자동차_이름이_5자를_초과하는_경우_예외가_발생한다")
    void 자동차_이름이_5자를_초과하는_경우_예외가_발생한다() {
        // given
        String carNamesInput = "abcdef,g";

        // when
        assertThatThrownBy(() -> run(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("main() : 자동차_이름이_공백인_경우_예외가_발생한다")
    void 자동차_이름이_공백인_경우_예외가_발생한다() {
        // given
        String carNamesInput = "a, ,b";

        // when
        assertThatThrownBy(() -> run(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("main() : 자동차_이름이_중복되는_경우_예외가_발생한다")
    void 자동차_이름이_중복되는_경우_예외가_발생한다() {
        // given
        String carNamesInput = "a,a,b";

        // when
        assertThatThrownBy(() -> run(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("main() : 자동차의_수가_1_대_미만인_경우_예외가_발생한다")
    void 자동차의_수가_1_대_미만인_경우_예외가_발생한다() {
        // given
        String carNamesInput = "\n";

        // when
        assertThatThrownBy(() -> run(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("main() : 시도_횟수가_0_이하인_경우_예외가_발생한다")
    void 시도_횟수가_0_이하인_경우_예외가_발생한다(String tryCountInput) {

        // when
        assertThatThrownBy(() -> run(validCarNamesInput, tryCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1.1", "["})
    @DisplayName("main() : 시도_횟수가_숫자가_아닌_경우_예외가_발생한다")
    void 시도_횟수가_숫자가_아닌_경우_예외가_발생한다(String tryCountInput) {

        // when
        assertThatThrownBy(() -> run(validCarNamesInput, tryCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("main() : 시도_횟수가_정수_Integer_범위를_초과하는_경우_예외가_발생한다")
    void 시도_횟수가_정수_Integer_범위를_초과하는_경우_예외가_발생한다() {
        // given
        String tryCountInput = Integer.MAX_VALUE + "1";

        // when
        assertThatThrownBy(() -> run(validCarNamesInput, tryCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
