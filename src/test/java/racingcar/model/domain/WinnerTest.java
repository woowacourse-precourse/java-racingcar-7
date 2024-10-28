package racingcar.model.domain;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.Assertions;
import racingcar.model.service.RaceService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

	@Test
	void 우승자가_한_명일_경우() {
		RaceService raceService = new RaceService(Delimiter.COMMA, "pobi,woni,jun", 5);

		Assertions.assertRandomNumberInRangeTest(
			() -> raceService.runResult(),
			4, 1, 1
		);

		List<String> winners = raceService.getWinners();
		assertThat(winners).isNotNull();
		assertThat(winners.size()).isEqualTo(1);
		assertThat(winners).contains("pobi");
	}

	@Test
	void 우승자가_여러_명일_경우() {
		RaceService raceService = new RaceService(Delimiter.COMMA, "pobi,woni,jun", 5);

		Assertions.assertRandomNumberInRangeTest(
			() -> raceService.runResult(),
			4, 4, 4
		);

		List<String> winners = raceService.getWinners();
		assertThat(winners).isNotNull();
		assertThat(winners.size()).isGreaterThan(1);
		assertThat(winners).contains("pobi", "woni", "jun");
	}
}