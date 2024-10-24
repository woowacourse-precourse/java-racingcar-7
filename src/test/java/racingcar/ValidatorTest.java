package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	@Test
	void validateCarName() {
		Validator.validateCarName("name");
		Validator.validateCarName("seven");

		assertThatThrownBy(() -> Validator.validateCarName("")).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> Validator.validateCarName("longer")).isInstanceOf(IllegalArgumentException.class);
	}
}