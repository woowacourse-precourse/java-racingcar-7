package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewTrialCountTest extends NsTest {
    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView();
    }

    @DisplayName("시도 횟수 입력을 받는다.")
    @MethodSource("inputTrialCount")
    @ParameterizedTest
    void inputTrialCount(String input, String output) {
        run(input);
        assertThat(output().contains(output)).isTrue();
    }

    private static Stream<Arguments> inputTrialCount() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("23", "23"),
                Arguments.of("2147483647", "2147483647")
        );
    }

    @Override
    protected void runMain() {
        int trialCount = inputView.inputTrialCount();
        System.out.println(trialCount);
    }
}
