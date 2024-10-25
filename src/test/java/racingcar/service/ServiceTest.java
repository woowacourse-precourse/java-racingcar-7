package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

class ServiceTest {
    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @DisplayName("이름을 \",\"로 구분하여 list 로 반환한다.")
    @MethodSource("provideSplitCarNamesTestCases")
    @ParameterizedTest(name = "기대값: \"{0}\", 입력값: \"{1}\"")
    void splitCarNames(ArrayList<String> expected, String carNames) {
        assertEquals(expected, service.splitCarNames(carNames));
    }

    @DisplayName("race 내 자동차들 중 최대 전진 값을 구한다.")
    @MethodSource("provideDistanceTestCases")
    @ParameterizedTest(name = "기대값: \"{0}\", 입력값: \"{1}\"")
    void getMaxDistance(int expectedMaxDistance, List<Integer> distanceList) {
        assertEquals(expectedMaxDistance, service.getMaxDistance(distanceList));
    }

    @DisplayName("우승자를 선정한다.")
    @MethodSource("provideGetWinnerCarTestCases")
    @ParameterizedTest(name = "기대 list: \"{0}\", 입력 list: \"{1}\", 최대 전진값: \"{2}\"")
    void getWinnerCar(List<Car> expectedCarList, List<Car> inputCarList, int maxDistance) {
        List<Car> winnerCarList = service.getCarListWithMaxDistance(inputCarList, maxDistance);

        assertEquals(expectedCarList.size(), winnerCarList.size());

        for (int idx = 0; idx < expectedCarList.size(); idx++) {
            assertEquals(expectedCarList.get(idx).getName(), winnerCarList.get(idx).getName());
            assertEquals(expectedCarList.get(idx).getLocation(),
                    winnerCarList.get(idx).getLocation());
        }
    }

    @DisplayName("입력받은 차 이름 리스트로 차 객체 리스트를 만든다.")
    @MethodSource("provideRegisterCarTestCases")
    @ParameterizedTest(name = "기대 자동차 list: \"{0}\", 자동차 이름 list: \"{1}\"")
    void registerCar(List<Car> expectedCarList, List<String> carNames) {
        List<Car> registerCarList = service.registerCar(carNames);

        assertEquals(expectedCarList.size(), registerCarList.size());

        for (int idx = 0; idx < expectedCarList.size(); idx++) {
            assertEquals(expectedCarList.get(idx).getName(), registerCarList.get(idx).getName());
            assertEquals(expectedCarList.get(idx).getLocation(),
                    registerCarList.get(idx).getLocation());
        }
    }


    private static Stream<Arguments> provideSplitCarNamesTestCases() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList("pobi", "woni", "jun")), "pobi,woni,jun")
        );
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

    private static Stream<Arguments> provideRegisterCarTestCases() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        return Stream.of(
                Arguments.of(Arrays.asList(pobi, woni, jun), Arrays.asList("pobi", "woni", "jun"))
        );
    }
}
