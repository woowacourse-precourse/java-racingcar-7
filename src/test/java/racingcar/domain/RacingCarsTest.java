package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 레이싱카들이_정상적으로_생성된다() {
        //given
        List<String> carNames = List.of("yeah", "jun");
        Integer totalAttempts = 4;
        //when
        RacingCars racingCars = RacingCars.createRacingCars(carNames, totalAttempts);
        //then
        assertAll(
                () -> assertThat(racingCars.getCars().stream().map(RacingCar::getCarName).toList()).isEqualTo(carNames),
                () -> assertThat(racingCars.getTotalAttempts()).isEqualTo(totalAttempts)
        );
    }

    @Test
    void 모든_레이싱카가_전진을_1회_시도한다() {
        //given
        RacingCars racingCars = RacingCars.createRacingCars(List.of("a!!"), 1);
        //when
        racingCars.attempt();
        //then
        assertThat(racingCars.getCurrentAttempts()).isEqualTo(1);
    }

    @Test
    void 정상적으로_단일_우승자를_결정한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    RacingCars racingCars = RacingCars.createRacingCars(List.of("we", "can"), 1);
                    racingCars.attempt();
                    List<RacingCar> winner = racingCars.findWinners();

                    assertThat(winner)
                            .hasSize(1)
                            .extracting(RacingCar::getCarName, RacingCar::getAdvanceCount)
                            .containsExactly(tuple("we", 1));
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 정상적으로_공동_우승자를_결정한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    RacingCars racingCars = RacingCars.createRacingCars(List.of("we", "love"), 1);
                    racingCars.attempt();
                    List<RacingCar> winners = racingCars.findWinners();

                    assertThat(winners)
                            .hasSize(2)
                            .extracting(RacingCar::getCarName, RacingCar::getAdvanceCount)
                            .containsExactlyInAnyOrder(
                                    tuple("we", 0),
                                    tuple("love", 0)
                            );
                },
                STOP, STOP
        );
    }

    @Test
    void 시도횟수만큼_시도하지_않으면_참을_반환한다() {
        //given
        RacingCars racingCars = RacingCars.createRacingCars(List.of("abc"), 3);
        //when
        racingCars.attempt();
        //then
        assertTrue(racingCars.isNotEnoughAttempts());
    }

    @Test
    void 시도횟수만큼_시도하면_거짓을_반환한다() {
        //given
        RacingCars racingCars = RacingCars.createRacingCars(List.of("abc"), 3);
        //when
        racingCars.attempt();
        racingCars.attempt();
        racingCars.attempt();
        //then
        assertFalse(racingCars.isNotEnoughAttempts());
    }
}