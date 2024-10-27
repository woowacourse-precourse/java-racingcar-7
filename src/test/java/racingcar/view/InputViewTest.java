package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.input.TestReader;
import racingcar.view.output.TestWriter;

class InputViewTest {

    private final TestReader reader = new TestReader();
    private final TestWriter writer = new TestWriter();
    private final InputView inputView = new InputView(reader, writer);

    @Test
    void inputCarNamesTest_checkPrintedMessage() {
        inputView.inputCarNames();

        assertThat(writer.getOutputText()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void inputCarNamesTest_checkCarNames() {
        reader.setInputText("pobi,woni,jun");
        List<String> expected = List.of("pobi", "woni", "jun");

        List<String> actual = inputView.inputCarNames();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void inputRoundCountTest_checkPrintedMessage() {
        reader.setInputText("1");

        inputView.inputRoundCount();

        assertThat(writer.getOutputText()).contains("시도할 횟수는 몇 회인가요?");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "2a"})
    void inputRoundCountTest_whenNotInputInt_throwException(String inputText) {
        reader.setInputText(inputText);

        assertThatThrownBy(() -> inputView.inputRoundCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자이어야 합니다");
    }

    @ParameterizedTest
    @CsvSource({"-1, -1", "0, 0", "100, 100"})
    void inputRoundCountTest_whenInputInt(String inputText, int expected) {
        reader.setInputText(inputText);

        int actual = inputView.inputRoundCount();

        assertThat(actual).isEqualTo(expected);
    }
}
