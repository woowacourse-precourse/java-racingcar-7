package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

	@Test
	void 자동차_이름이_다섯글자_이상인_경우() {
		String name = "abcdefg";

		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(name));
	}

	@Test
	void 이동횟수가_숫자가_아닌_경우() {
		String num = "a";

		Assertions.assertThrows(IllegalArgumentException.class, () -> Input.validateAttemptNumber(num));
	}

	@Test
	void 이동횟수가_양수가_아닌_경우() {
		String num = "-3";

		Assertions.assertThrows(IllegalArgumentException.class, () -> Input.validateAttemptNumber(num));
	}
}
