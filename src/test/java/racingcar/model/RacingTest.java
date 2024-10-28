package racingcar.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingTest {

    private static final int FORWARD = 9;
    private static final int STOP = 1;

    private static List<Car> cars;
    private static int totalTryCount;
    private static Racing racing;

    @BeforeAll
    static void setup() {
        cars = List.of(new Car("pobi"), new Car("won"), new Car("jun"));
        totalTryCount = 2;
    }

    private static List<String> carToString(List<Car> cars){
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("최종 우승자가 1명인 경우")
    void testGetSingleWinner() {
        List<String> expectedWinner = List.of("won");
        int expectedMaxPosition = 2;

        assertRandomNumberInRangeTest(
                () -> {
                    racing = new Racing(cars,totalTryCount);
                    racing.startRace();
                    List<String> result = carToString(racing.getWinners());
                    assertThat(racing.getMaxPosition()).isEqualTo(expectedMaxPosition);
                    assertThat(result).isEqualTo(expectedWinner);
                },
                STOP, FORWARD, FORWARD,
                STOP, FORWARD, STOP
        );
    }

    @Test
    @DisplayName("최종 우승자가 다수인 경우")
    void testFindMultipleWinner() {
        List<String> expectedWinner = List.of("won", "jun");
        int expectedMaxPosition = 2;

        assertRandomNumberInRangeTest(
                () -> {
                    racing = new Racing(cars,totalTryCount);
                    racing.startRace();
                    List<String> result = carToString(racing.getWinners());
                    assertThat(racing.getMaxPosition()).isEqualTo(expectedMaxPosition);
                    assertThat(result).isEqualTo(expectedWinner);
                },
                STOP, FORWARD, FORWARD,
                STOP, FORWARD, FORWARD
        );
    }
}
