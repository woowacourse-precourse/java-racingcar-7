package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TurnTest {

	@Test
	@DisplayName("시도 횟수는 자연수만 가능하다.")
	void turn_can_only_be_natural_number(){
		// given
		int turnCount = 1;

		// when
		Turn turn = new Turn(turnCount);

		// then
		Assertions.assertThat(turn.getTurnCount()).isEqualTo(1);
	}

	@Test
	@DisplayName("시도 횟수가 자연수가 아닌 경우 예외가 발생한다.")
	void if_turn_is_not_natural_number_exception(){
		// given,  when, then
		Assertions.assertThatThrownBy(() -> new Turn(0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 자연수만 가능합니다.");
	}
}
