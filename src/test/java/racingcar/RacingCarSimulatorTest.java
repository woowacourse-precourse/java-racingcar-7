package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class RacingCarSimulatorTest {
	@Test
	void getWinners() {
		RacingCarSimulator simulator = new RacingCarSimulator();

		assertThat(simulator.getWinners(
			List.of("name1", "name2", "name3"),
			List.of(0L, 1L, 2L)
		)).containsExactly("name3");

		assertThat(simulator.getWinners(
			List.of("name1", "name2", "name3"),
			List.of(1L, 2L, 1L)
		)).containsExactly("name2");

		assertThat(simulator.getWinners(
			List.of("name1", "name2", "name3"),
			List.of(1L, 2L, 2L)
		)).containsExactly("name2", "name3");

		assertThat(simulator.getWinners(
			List.of("name1", "name2", "name3"),
			List.of(2L, 2L, 2L)
		)).containsExactly("name1", "name2", "name3");
	}
}