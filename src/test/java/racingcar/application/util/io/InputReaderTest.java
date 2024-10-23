package racingcar.application.util.io;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;

import java.util.List;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class InputReaderTest extends NsTest {

    @Nested
    @DisplayName("[통과 시나리오]")
    class 정상적인_통과_시나리오_테스트 {

        private static final String RESULT_DELIMITER_BETWEEN_NAME_AND_DISTANCE = " : ";

        @ParameterizedTest(name = "({index}) 이름 입력 : {0} / 시도횟수 입력 : {1}")
        @CsvSource(
                value = {
                        "pobi,woni,jun;5", "pobi;5", "woni,jun;5", "dong ,   gyu , pobi  ;5"
                },
                delimiter = ';'
        )
        @DisplayName("올바른 입력 시나리오")
        void 올바른__입력_시나리오(
                // given
                String availableNameInput,
                String availableTrialInput
        ) {
            List<String> mustContainOutputs = Arrays.stream(availableNameInput.split(","))
                    .map(name -> name.trim() + RESULT_DELIMITER_BETWEEN_NAME_AND_DISTANCE)
                    .toList();

            // when & then
            assertSimpleTest(() ->
                    assertThatCode(() -> {
                        run(availableNameInput, availableTrialInput);
                        assertThat(output()).contains(mustContainOutputs);
                    }).doesNotThrowAnyException()
            );
        }

    }
    @Nested
    @DisplayName("[실패 시나리오]")
    class 비정상적인_실패_시나리오_테스트 {

        @ParameterizedTest(name = "({index}) 이름 입력 : {0} / 시도횟수 입력 : {1}")
        @CsvSource(
                value = {
                        ",woni,jun;5", ",,,;5", ",woni,;5", ",woni;5"
                },
                delimiter = ';'
        )
        @DisplayName("잘못된 이름 입력 입력 시나리오")
        void 잘못된_이름_입력_시나리오(
                // given
                String invalidNameInput,
                String availableTrialInput
        ) {
            // when & then
            assertSimpleTest(() ->
                    assertThatCode(() -> runException(invalidNameInput, availableTrialInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @ParameterizedTest(name = "({index}) 이름 입력 : {0} / 시도횟수 입력 : {1}")
        @CsvSource(
                value = {
                        "pobi,woni,jun;%^&", "pobi,woni,jun;가나다", "pobi,woni,jun;12v", "pobi,woni,jun;abc"
                },
                delimiter = ';'
        )
        @DisplayName("잘못된 시도횟수 입력 입력 시나리오")
        void 잘못된_시도횟수_입력_시나리오(
                // given
                String availableNameInput,
                String invalidTrialInput
        ) {
            // when & then
            assertSimpleTest(() ->
                    assertThatCode(() -> runException(availableNameInput, invalidTrialInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}