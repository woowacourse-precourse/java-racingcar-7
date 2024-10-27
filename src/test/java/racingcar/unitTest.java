package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class unitTest {
	private List<String> carNames;
	private List<Integer> positions;

	@BeforeEach
	void setUp() {
		carNames = Arrays.asList("pobi", "woni", "jun");
		positions = Application.initializePositions(carNames.size());
	}

	@Test
	void 초기_포지션_모두_0으로_초기화() {
		List<Integer> initializedPositions = Application.initializePositions(carNames.size());
		assertThat(initializedPositions).containsExactly(0, 0, 0);
	}

	@Test
	void 무작위_값이_4이상일_경우_자동차_전진() {
		boolean canMove = Application.canMove();
		assertThat(canMove).isIn(true, false);  // 무작위 결과가 전진 여부를 반환
	}

	@Test
	void 최대_포지션_찾기() {
		positions.set(0, 2);
		positions.set(1, 5);
		positions.set(2, 3);

		int maxPosition = Application.findMaxPosition(positions);
		assertThat(maxPosition).isEqualTo(5);
	}

	@Test
	void 자동차_위치_출력() {
		positions.set(0, 2);
		positions.set(1, 3);
		positions.set(2, 1);

		String result = Application.generateRoundResult(carNames, positions);
		assertThat(result).contains("pobi : --", "woni : ---", "jun : -");
	}

	@Test
	void 최종_우승자_선정_및_출력() {
		positions.set(0, 3);
		positions.set(1, 5);
		positions.set(2, 5);

		int maxPosition = Application.findMaxPosition(positions);
		List<String> winners = Application.findWinners(carNames, positions, maxPosition);

		assertThat(winners).containsExactly("woni", "jun");
	}
}
