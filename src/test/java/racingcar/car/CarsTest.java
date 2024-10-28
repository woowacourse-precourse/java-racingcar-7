package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

class CarsTest {

	@Test
	void 이름_중복_체크_성공() {
		String[] names = new String[]{"pobi", "jun", "woni"};

		assertThatNoException()
				.isThrownBy(() -> new Cars(names));
	}

	@Test
	void 이름_중복_체크_실패() {
		String[] names = new String[]{"pobi", "jun", "pobi"};

		assertThatIllegalArgumentException()
				.isThrownBy(() -> new Cars(names));
	}
}
