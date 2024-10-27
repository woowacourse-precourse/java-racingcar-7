package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
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
}
