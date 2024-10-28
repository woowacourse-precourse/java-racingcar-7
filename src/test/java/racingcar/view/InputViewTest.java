package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputViewTest extends ConsoleIOTest {
	private InputView inputView;

	@BeforeEach
	void setUp() {
		inputView = new InputView();
	}

	@Test
	void 콘솔에_입력된_값을_반환() {
		String input = "tom,jerry,alice";
		setConsoleInput(input);
		String readValue = inputView.readConsole();
		assertThat(readValue).isEqualTo(input);
	}
}