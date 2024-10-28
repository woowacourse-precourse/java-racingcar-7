package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.constant.Constant.MOVE_FORWARD_RANGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarDomainsTest {
    private CarDomains carDomains;

    @BeforeEach
    public void setUp() {
        CarDomain car1 = CarDomain.create("Car1", 0);
        CarDomain car2 = CarDomain.create("Car2", 0);
        carDomains = CarDomains.create(Arrays.asList(car1, car2));
    }

    @Test
    @DisplayName("자동차_초기화_테스트")
    public void testInitialCars() {
        assertSimpleTest(() -> {
            List<CarDomain> cars = carDomains.getCarDomainList();
            assertNotNull(cars);
            assertEquals(2, cars.size());
            assertEquals("Car1", cars.get(0).getName());
            assertEquals("Car2", cars.get(1).getName());
            assertEquals(0, cars.get(0).getDistance());
            assertEquals(0, cars.get(1).getDistance());
        });
    }

    @Test
    @DisplayName("우승자_인스턴스_테스트")
    public void testGetWinnersInstance() {
        assertRandomNumberInRangeTest(() -> {
            CarDomains winners = carDomains.getWinnersInstance();

            assertNotNull(winners);
            assertEquals(carDomains.getCarDomainList().size(), winners.getCarDomainList().size());

            carDomains.executeOneRound();

            winners = carDomains.getWinnersInstance();
            assertEquals(1, winners.getCarDomainList().size());
        }, MOVE_FORWARD_RANGE.min(), IntStream.range(0, carDomains.getCarDomainList().size() - 1)
                .mapToObj(i -> MOVE_FORWARD_RANGE.min() - 1)
                .toArray(Integer[]::new));
    }

    @Test
    @DisplayName("한_라운드_실행_테스트")
    public void testExecuteOneRound() {
        assertRandomNumberInRangeTest(() -> {
            int distanceCar1 = carDomains.getCarDomainList().get(0).getDistance();
            int distanceCar2 = carDomains.getCarDomainList().get(1).getDistance();

            carDomains.executeOneRound();

            assertNotEquals(distanceCar1, carDomains.getCarDomainList().get(0).getDistance());
            assertNotEquals(distanceCar2, carDomains.getCarDomainList().get(1).getDistance());
        }, MOVE_FORWARD_RANGE.min(), IntStream.range(0, carDomains.getCarDomainList().size() - 1)
                .mapToObj(i -> MOVE_FORWARD_RANGE.min())
                .toArray(Integer[]::new));
    }
}
