package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

public class RaceServiceTest {
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
    }

    @DisplayName("레이스 내 자동차들 중 최대 전진 값을 구한다.")
    @MethodSource("provideDistanceTestCases")
    @ParameterizedTest(name = "기대값: \"{0}\", 입력값: \"{1}\"")
    void getMaxDistance(int expectedMaxDistance, List<Integer> distanceList) {
        assertEquals(expectedMaxDistance, raceService.getMaxDistance(distanceList));
    }

    @DisplayName("우승자를 선정한다.")
    @MethodSource("provideGetWinnerCarTestCases")
    @ParameterizedTest(name = "기대값: \"{0}\", 입력값: \"{1}\", 최대 전진값: \"{2}\"")
    void getWinnerCar(List<Car> expectedCarList, List<Car> inputCarList, int maxDistance) {
        List<Car> winnerCarList = raceService.getCarListWithMaxDistance(inputCarList, maxDistance);

        assertEquals(expectedCarList, winnerCarList);
    }

    private static Stream<Arguments> provideDistanceTestCases() {
        return Stream.of(
                Arguments.of(5, Arrays.asList(5, 4, 5)),
                Arguments.of(5, Arrays.asList(5, 1, 3))
        );
    }

    private static Stream<Arguments> provideGetWinnerCarTestCases() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        Car gonagi = new Car("gonagi");

        pobi.plusLocation();
        pobi.plusLocation();
        pobi.plusLocation();

        woni.plusLocation();
        woni.plusLocation();

        jun.plusLocation();
        jun.plusLocation();

        gonagi.plusLocation();

        return Stream.of(
                Arguments.of(List.of(pobi), Arrays.asList(pobi, woni, jun), 3),
                Arguments.of(Arrays.asList(woni, jun), Arrays.asList(woni, jun, gonagi), 2)
        );
    }
}
