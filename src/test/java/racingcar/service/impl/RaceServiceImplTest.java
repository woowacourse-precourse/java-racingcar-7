package racingcar.service.impl;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.constant.Constant.MOVE_FORWARD_RANGE;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDomain;
import racingcar.domain.CarDomains;
import racingcar.domain.RaceDomain;

class RaceServiceImplTest {
    private RaceServiceImpl raceService;
    private RaceDomain raceDomain;
    private CarDomains carDomains;

    @BeforeEach
    void setUp() {
        raceService = RaceServiceImpl.getInstance();

        CarDomain car1 = CarDomain.create("Car1", 0);
        CarDomain car2 = CarDomain.create("Car2", 0);
        carDomains = CarDomains.create(Arrays.asList(car1, car2));

        raceDomain = RaceDomain.create(carDomains, 3);
    }

    @Test
    @DisplayName("한_라운드_실행_테스트")
    void testRunOneRound() {
        assertRandomNumberInRangeTest(() -> {
            assertEquals(0, raceDomain.getCurrentRound());

            raceService.runOneRound(raceDomain);

            assertEquals(1, raceDomain.getCurrentRound());
            assertEquals(1, carDomains.getCarDomainList().get(0).getDistance());
            assertEquals(0, carDomains.getCarDomainList().get(1).getDistance());
        }, MOVE_FORWARD_RANGE.min(), IntStream.range(0, carDomains.getCarDomainList().size() - 1)
                .mapToObj(i -> MOVE_FORWARD_RANGE.min() - 1)
                .toArray(Integer[]::new));
    }

    @Test
    @DisplayName("우승자_조회_테스트")
    void testGetWinners() {
        assertRandomNumberInRangeTest(() -> {
                    raceService.runOneRound(raceDomain);
                    raceService.runOneRound(raceDomain);
                    raceService.runOneRound(raceDomain);

                    CarDomains winners = raceService.getWinners(raceDomain);

                    assertNotNull(winners);
                    assertEquals(1, winners.getCarDomainList().size());
                }, MOVE_FORWARD_RANGE.min() - 1,
                IntStream.range(0, (carDomains.getCarDomainList().size() * raceDomain.getLastRound() - 1))
                        .mapToObj(i -> MOVE_FORWARD_RANGE.min())
                        .toArray(Integer[]::new));
    }

    @Test
    @DisplayName("현재_라운드_마지막_라운드_초과_불가_테스트")
    void testCurrentRoundCannotExceedLastRound() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    raceService.runOneRound(raceDomain);
                    raceService.runOneRound(raceDomain);
                    raceService.runOneRound(raceDomain);
                    raceService.runOneRound(raceDomain);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }
}