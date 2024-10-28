package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.constant.Constant.MOVE_FORWARD_RANGE;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceDomainTest {
    private RaceDomain raceDomain;

    @BeforeEach
    public void setUp() {
        CarDomain car1 = CarDomain.create("Car1", 0);
        CarDomain car2 = CarDomain.create("Car2", 0);
        CarDomains carDomains = CarDomains.create(Arrays.asList(car1, car2));
        raceDomain = RaceDomain.create(carDomains, 3);
    }

    @Test
    @DisplayName("경주_초기화_테스트")
    public void testInitialRace() {
        assertSimpleTest(() -> {
            assertNotNull(raceDomain.getCars());
            assertEquals(0, raceDomain.getCurrentRound());
            assertEquals(3, raceDomain.getLastRound());
        });
    }

    @Test
    @DisplayName("한_라운드_실행_테스트")
    public void testExecuteOneRound() {
        assertSimpleTest(() -> {
            raceDomain.executeOneRound();
            assertEquals(1, raceDomain.getCurrentRound());

            raceDomain.executeOneRound();
            assertEquals(2, raceDomain.getCurrentRound());

            raceDomain.executeOneRound();
            assertEquals(3, raceDomain.getCurrentRound());
        });
    }

    @Test
    @DisplayName("우승자_인스턴스_조회_테스트")
    public void testGetWinnersInstance() {
        assertRandomNumberInRangeTest(() -> {
                    CarDomains winners = raceDomain.getWinnersInstance();
                    assertNotNull(winners);
                    assertEquals(raceDomain.getCars().getCarDomainList().size(), winners.getCarDomainList().size());

                    raceDomain.executeOneRound();

                    winners = raceDomain.getWinnersInstance();
                    assertNotNull(winners);
                    assertFalse(winners.getCarDomainList().isEmpty());
                }, MOVE_FORWARD_RANGE.min(),
                IntStream.range(0, raceDomain.getCars().getCarDomainList().size() - 1)
                        .mapToObj(i -> MOVE_FORWARD_RANGE.min())
                        .toArray(Integer[]::new)
        );
    }

    @Test
    @DisplayName("현재_라운드_제한_테스트")
    public void testCurrentRoundLimit() {
        assertSimpleTest(() -> {
            IntStream.range(0, raceDomain.getLastRound()).forEach(i -> raceDomain.executeOneRound());
            assertEquals(raceDomain.getLastRound(), raceDomain.getCurrentRound());
        });
    }
}