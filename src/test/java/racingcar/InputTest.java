package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputTest {

	@Test
	void 자동차_이름_나누기() {
		String input = "pobi,woni";
		CarList carList = Input.separateNames(input);

		Assertions.assertThat(carList.getCars())
			.extracting(Car::getName)
			.contains("pobi", "woni");
	}

	@Test
	void 이동횟수_입력받기() {
		String input = "3";

		Assertions.assertThat(Input.validateAttemptNumber(input)).isEqualTo(3);
	}
}
