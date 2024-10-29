package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
	@ParameterizedTest
	@ValueSource(strings = {"1l", "O", "1O"})
	void 숫자가_아닐_때(String input) {
		Cars cars = new Cars(new String[] {"이름1", "이름2"});
		assertThatThrownBy(() -> Game.fromInputAndCars(input, cars))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Game.TRY_COUNT_MUST_BE_NUMBER);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-10", "-9999", "-1"})
	void 양수가_아닐_때(String input) {
		Cars cars = new Cars(new String[] {"이름1", "이름2"});
		assertThatThrownBy(() -> Game.fromInputAndCars(input, cars))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Game.TRY_COUNT_MUST_BE_POSITIVE_NUMBER);
	}

	@ParameterizedTest
	@ValueSource(strings = {"10", "0", "1000"})
	void 올바른_시도_횟수일_때(String input) {
		Cars cars = new Cars(new String[] {"이름1", "이름2"});
		assertDoesNotThrow(() -> Game.fromInputAndCars(input, cars));

	}
}
