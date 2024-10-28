package racingcar.model.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.Assertions;

class AttemptNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {-50, -10, -1})
	void 시도_횟수가_음수일_경우_예외(int attemptNumber) {
		Assertions.assertSimpleTest(() -> {
			assertThatThrownBy(() -> Validator.validateAttemptNumber(attemptNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(ErrorMessage.NEGATIVE_ATTEMPT_NUMBER.getMessage());
		});
	}

	@Test
	void 시도_횟수가_0일_경우_예외() {
		Assertions.assertSimpleTest(() -> {
			assertThatThrownBy(() -> Validator.validateAttemptNumber(0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(ErrorMessage.NEGATIVE_ATTEMPT_NUMBER.getMessage());
		});
	}
}