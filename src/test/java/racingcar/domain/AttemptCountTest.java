package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("경주 시도 횟수 테스트")
class AttemptCountTest {

	@Test
	@DisplayName("시도 횟수가 양수가 아닐 경우, 예외를 반환한다.")
	void Throw_Exception_When_Attempt_Count_Not_Positive() {
		// given
		int input = 0;

		// when, then
		assertThatThrownBy(() -> new AttemptCount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ATTEMPT_COUNT_NOT_POSITIVE.getMessage());
	}
}