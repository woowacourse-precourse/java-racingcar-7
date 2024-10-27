package racingcar.racinggame.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

	@DisplayName("시도 횟수 기억할 수 있다")
	@Test
	void from() {
		// given
		int tryCount = 11;

		// when
		TryCount result = TryCount.from(tryCount);

		// then
		assertThat(result.getCount()).isEqualTo(11);
	}

	@DisplayName("범위를 벗어난 시도 횟수를 사용할 수 없다")
	@ValueSource(ints = {-1, 0, 10001})
	@ParameterizedTest(name = "{0}은 시도 횟수로 사용할 수 없습니다.")
	void from(int tryCount) {
		// when // then
		assertThatThrownBy(() -> TryCount.from(tryCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수가 지정된 범위를 벗어났습니다.");
	}

}