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

public class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @DisplayName("이름을 \",\"로 구분하여 list 로 반환한다.")
    @MethodSource("provideSplitCarNamesTestCases")
    @ParameterizedTest(name = "기대값: \"{0}\", 입력값: \"{1}\"")
    void splitCarNames(List<String> expected, String carNames) {
        assertEquals(expected, carService.splitCarNames(carNames));
    }

    @DisplayName("입력받은 차 이름 리스트로 차 객체 리스트를 만든다.")
    @MethodSource("provideRegisterCarTestCases")
    @ParameterizedTest(name = "기대값: \"{0}\", 입력값: \"{1}\"")
    void registerCar(List<Car> expectedCarList, List<String> carNames) {
        List<Car> registerCarList = carService.registerCar(carNames);

        assertEquals(expectedCarList, registerCarList);
    }

    private static Stream<Arguments> provideSplitCarNamesTestCases() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni", "jun"), "pobi,woni,jun")
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
