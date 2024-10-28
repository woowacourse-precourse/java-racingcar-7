package racingcar.view;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

	@Override
	protected void runMain() {
	}

	@Test
	void 자동차_이름_입력_확인() {
		Assertions.assertSimpleTest(() -> {
			run("pobi");
			String carNames = InputView.getCarNames();
			assertThat(carNames).isEqualTo("pobi");
		});
	}

	@Test
	void 시도_숫자_입력_확인() {
		Assertions.assertSimpleTest(() -> {
			run("5");
			int attemptNumber = InputView.getAttemptNumber();
			assertThat(attemptNumber).isEqualTo(5);
		});
	}
}