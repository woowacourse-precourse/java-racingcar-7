package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

class ApplicationTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void 기능_테스트() {
		String name = "pobi,woni";
		String attempts = "1";

		assertRandomNumberInRangeTest(
			() -> {
				run(name, attempts);
				assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
			},
			MOVING_FORWARD, STOP
		);
	}

	@Test
	void 예외_테스트() {
		String name = "pobi,javaji";
		String attempts = "1";

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(name, attempts))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 복수_우승자_선정_테스트() {
		String name = "pobi,woni";
		String attempts = "1";

		assertRandomNumberInRangeTest(
			() -> {
				run(name, attempts);
				assertThat(output()).contains(
					"pobi : -",
					"woni : -",
					"최종 우승자 : pobi, woni"
				);
			},
			MOVING_FORWARD, MOVING_FORWARD
		);
	}

	@Test
	void 입력된_횟수만큼_게임_진행_테스트() {
		String name = "pobi,woni";
		String attempts = "3";

		assertRandomNumberInRangeTest(
			() -> {
				run(name, attempts);

				String result = output();
				String[] rounds = result.split("\n");

				long gameRounds = Arrays.stream(rounds)
					.filter(line -> line.contains(" : "))
					.count();

				assertThat(gameRounds).isEqualTo(Integer.parseInt(attempts) * 2 + 1);
			},
			MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
		);
	}

	@Test
	void 이름_공백_제거_테스트() {
		String name = "pobi,woni";
		String attempts = "1";

		assertRandomNumberInRangeTest(
			() -> {
				run(name, attempts);
				assertThat(output()).contains(
					"pobi : -",
					"woni : ",
					"최종 우승자 : pobi"
				);
			},
			MOVING_FORWARD, STOP
		);
	}

	@Test
	void 이름이_비어있는_경우_예외_테스트() {
		String name = "";
		String attempts = "1";

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(name, attempts))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름이_공백만_있는_경우_예외_테스트() {
		String name = " ";
		String attempts = "1";

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(name, attempts))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 이름_중복_예외_테스트() {
		String name = "pobi,pobi";
		String attempts = "1";

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(name, attempts))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 시도_횟수가_0인_경우_예외_테스트() {
		String name = "pobi,woni";
		String attempts = "0";

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(name, attempts))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 시도_횟수가_음수인_경우_예외_테스트() {
		String name = "pobi,woni";
		String attempts = "-1";

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(name, attempts))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 시도_횟수가_숫자가_아닌_경우_예외_테스트() {
		String name = "pobi,woni";
		String attempts = "abc";

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(name, attempts))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
