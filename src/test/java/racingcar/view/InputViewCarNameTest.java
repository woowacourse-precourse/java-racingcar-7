package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.InputValidator;

class InputViewCarNameTest extends NsTest {
    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView(new InputValidator());
    }

    @DisplayName("쉼표(,)를 구분자로 자동차의 이름을 입력받는다.")
    @MethodSource("inputCarNames")
    @ParameterizedTest
    void inputCarNamesWithSeparator(String input, String output) {
        run(input);
        assertTrue(output().contains(output));
    }

    @DisplayName("자동차의 이름은 공백이 될 수 없다.")
    @ValueSource(strings = {" ", "   ", ",,,"})
    @ParameterizedTest
    void inputCarEmptyNamesFailureTest(String input) {
        assertThatThrownBy(() -> {
            run(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> inputCarNames() {
        return Stream.of(
                Arguments.of("pobi,woni", "[pobi, woni]"),
                Arguments.of(" corpi ", "[corpi]"),
                Arguments.of("   corpi, pobi", "[corpi, pobi]")
        );
    }

    @Override
    protected void runMain() {
        List<String> carNameList = inputView.inputCarNameList();
        System.out.println(carNameList);
    }
}