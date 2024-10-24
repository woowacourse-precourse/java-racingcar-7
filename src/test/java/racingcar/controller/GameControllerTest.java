package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class GameControllerTest {
	@Test
	void inputNames(){
		assertThat(GameController.inputName("taehoon,bangdori")).isEqualTo(Arrays.asList("taehoon", "bangdori"));
	}

	@Test
	void 음수를_입력하면_예외를_발생(){
		assertThatThrownBy(() -> GameController.inputName("taehoon,bangdori,taehoon"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이름이 중복됨");
	}
}