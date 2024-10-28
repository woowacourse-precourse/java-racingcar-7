package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;


public class RaceTest {
    private Race race;
    private static final int MOVING_FORWARD = 4;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        race = new Race(carNames);
    }

    @Test
    void 자동차_초기화_성공_테스트() {
        assertThat(race.getCars()).hasSize(3);
        assertThat(race.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(race.getCars().get(1).getName()).isEqualTo("woni");
        assertThat(race.getCars().get(2).getName()).isEqualTo("jun");

        for (Car car : race.getCars()) {
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Test
    void 우승자_리턴_테스트() {
        List<String> expectedWinner = List.of("pobi");

        assertRandomNumberInRangeTest(
                () -> {
                    race.getCars().get(0).move();
                },
                MOVING_FORWARD
        );

        List<Car> actualWinner = race.getWinners();
        List<String> actualWinnerName = actualWinner.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(actualWinnerName).isEqualTo(expectedWinner);
    }

    @Test
    void 공동_우승자_리턴_테스트() {
        List<String> expectedWinners = List.of("pobi", "jun");

        assertRandomNumberInRangeTest(
                () -> {
                    race.getCars().get(0).move();
                    race.getCars().get(2).move();
                },
                MOVING_FORWARD
        );

        List<Car> actualWinner = race.getWinners();
        List<String> actualWinnersName = actualWinner.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(actualWinnersName).isEqualTo(expectedWinners);
    }

}
