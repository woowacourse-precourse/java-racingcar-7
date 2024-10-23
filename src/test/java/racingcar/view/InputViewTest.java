package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

	private InputView inputView = InputView.getInstance();

	@Test
	@DisplayName("자동차 이름을 쉼표로 구분한다.")
	public void readCarNames() {
		// GIVEN
		String input = "a,b,c,d,e,f";

		// WHEN
		List<String> names = inputView.splitNames(input);

		// THEN
		assertThat(names).hasSize(6);
		assertThat(names).contains("a", "b", "c", "d", "e", "f");
	}

	@Test
	@DisplayName("구분자 내에 빈 이름이 있을 경우, IllegalArgumentException을 발생시킨다.")
	public void isEmptyName() {
		// GIVEN
		String input = "a,b,c,,e";

		// WHEN - THEN
		assertThatThrownBy(() -> {
			inputView.splitNames(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
