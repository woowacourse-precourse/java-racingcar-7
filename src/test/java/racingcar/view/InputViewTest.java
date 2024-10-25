package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
	@ParameterizedTest(name = "{index}번째 테스트 - [{0}]")
	@ValueSource(strings = {"  ", ""})
	void 빈_차_이름_테스트(String input) {
		InputView inputView = new InputView(() -> input);

		assertThatThrownBy(inputView::getCarNames)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(InputView.INPUT_CANNOT_BE_EMPTY);
	}

	@ParameterizedTest(name = "{index}번째 테스트 - [{0}]")
	@ValueSource(strings = {",", "ABKO,MILD"})
	void 입력값이_비어있지_않을_때(String input) {
		// given
		InputView inputView = new InputView(() -> input);
		String[] split = input.split(",");

		// when
		String[] carNames = inputView.getCarNames();

		// then
		assertThat(split).isEqualTo(carNames);
	}
}
