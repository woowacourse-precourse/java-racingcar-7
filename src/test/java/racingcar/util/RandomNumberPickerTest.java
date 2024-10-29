package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("난수 생성 테스트")
class RandomNumberPickerTest {

	@Test
	@DisplayName("난수를 뽑았을 때 0 이상 9 이하의 숫자가 반환된다.")
	void Pick_Number_Between_0_And_9() {
		// when
		int pickedNumber = RandomNumberPicker.pickNumber();

		// then
		assertThat(pickedNumber).isBetween(0, 9);
	}
}