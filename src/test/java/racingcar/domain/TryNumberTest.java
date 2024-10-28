package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberTest {

	@DisplayName("시도 횟수가 음수가 입력됐는지 확인한다.")
	@Test
	void doesTryNmuberNegativeTest() {
		// given
		TryNumber tryNumber = TryNumber.from(-1);

		// when

		// then
		assertThat(tryNumber.doesTryNumberNegative())
			.isTrue();
	}

	@DisplayName("시도 횟수가 0인지 확인한다.")
	@Test
	void isSameNumberZeroTest() {
		// given
		TryNumber tryNumber = TryNumber.from(0);

		// when

		// then
		assertThat(tryNumber.isSameTryNumberZero())
			.isTrue();
	}

}