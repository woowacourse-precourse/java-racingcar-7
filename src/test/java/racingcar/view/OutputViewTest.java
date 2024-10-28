package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.OutputPrefix.RACE_RESULT_RESPONSE_PREFIX;

import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest extends ConsoleIOTest {
	private OutputView outputView;
	private Scanner scanner;

	@BeforeEach
	void setUp() {
		outputView = new OutputView();
	}

	@Test
	void 콘솔_출력_반환() {
		String value = "test";
		String expected = RACE_RESULT_RESPONSE_PREFIX.getMessage() + value;
		outputView.printMessage(RACE_RESULT_RESPONSE_PREFIX, value);
		assertThat(expected).isEqualTo(getOutput());
	}
}