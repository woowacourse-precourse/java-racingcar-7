package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;
import racingcar.dto.RaceResultDto;
import racingcar.support.SequentialMovingStrategy;

class RacingServiceTest {

    @Test
    void 레이스를_생성하고_실행한다() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        int roundCount = 3;
        RacingService racingService = new RacingService();

        // when
        RaceResultDto result = racingService.createAndExecute(carNames, roundCount,
                SequentialMovingStrategy.sequence(
                        true, false, false,   // 첫 번째 라운드: pobi만 이동
                        true, true, false,    // 두 번째 라운드: pobi, woni 이동
                        false, false, false   // 세 번째 라운드: 아무도 이동 안 함
                )
        );

        // then
        assertSoftly(softly -> {
            softly.assertThat(result.raceHistory())
                    .hasSize(3);  // 3라운드

            // 첫 번째 라운드: pobi만 이동
            var firstRound = result.raceHistory().get(0).carPositions();
            softly.assertThat(firstRound)
                    .extracting(CarPositionDto::name, CarPositionDto::position)
                    .containsExactlyInAnyOrder(
                            tuple("pobi", 1),
                            tuple("woni", 0),
                            tuple("jun", 0)
                    );

            // 두 번째 라운드: pobi, woni 이동
            var secondRound = result.raceHistory().get(1).carPositions();
            softly.assertThat(secondRound)
                    .extracting(CarPositionDto::name, CarPositionDto::position)
                    .containsExactlyInAnyOrder(
                            tuple("pobi", 2),
                            tuple("woni", 1),
                            tuple("jun", 0)
                    );

            // 세 번째 라운드: 아무도 이동 안 함
            var thirdRound = result.raceHistory().get(2).carPositions();
            softly.assertThat(thirdRound)
                    .extracting(CarPositionDto::name, CarPositionDto::position)
                    .containsExactlyInAnyOrder(
                            tuple("pobi", 2),
                            tuple("woni", 1),
                            tuple("jun", 0)
                    );

            // pobi가 우승
            softly.assertThat(result.winners().winners())
                    .containsExactly("pobi");
        });
    }
}
