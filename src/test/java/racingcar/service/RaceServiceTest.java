package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import java.util.List;

class RaceServiceTest {
    private RaceService raceService;
    @BeforeEach
    void setUp () {
        raceService = new RaceService();
    }

    @Test
    void makeCarList_successTest () {
        // given
        String[] carNameList = {"jeong", "hun"};

        // when
        List<Car> carList = raceService.makeCarList(carNameList);

        // then
        assertThat(carList).hasSize(2);
        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getCarName()).isEqualTo(carNameList[i]);
        }
    }

    @Test
    void race_increaseLocationTest () {
        assertRandomNumberInRangeTest(
            () -> {
                // given
                List<Car> carList = List.of(new Car("jeong"), new Car("hun"));

                // when
                raceService.race(carList);

                // then
                assertThat(carList.get(0).getLocation()).isEqualTo(0);
                assertThat(carList.get(1).getLocation()).isEqualTo(1);
            },
            3, 4
        );
    }

    @Test
    void checkMaxLocation_successTest () {
        assertRandomNumberInRangeTest(
            () -> {
                // given
                List<Car> carList = List.of(new Car("jeong"), new Car("hun"));

                // when
                raceService.race(carList);
                raceService.race(carList);
                int maxLocation = raceService.checkMaxLocation(carList);

                // then
                assertThat(maxLocation).isEqualTo(2);
            },
            3, 4, 3, 4
        );
    }

    @Test
    void checkWinner_successOneWinnerTest () {
        // given
        List<Car> carList = List.of(new Car("jeong"), new Car("hun"));
        int maxLocation = 1;

        // when
        carList.get(0).increaseLocation();
        String winner = raceService.checkWinner(carList, maxLocation);

        assertThat(winner).isEqualTo("jeong");
    }

    @Test
    void checkWinner_successTwoWinnerTest () {
        // given
        List<Car> carList = List.of(new Car("jeong"), new Car("hun"));
        int maxLocation = 1;

        // when
        carList.get(0).increaseLocation();
        carList.get(1).increaseLocation();
        String winner = raceService.checkWinner(carList, maxLocation);

        assertThat(winner).isEqualTo("jeong,hun");
    }
}
