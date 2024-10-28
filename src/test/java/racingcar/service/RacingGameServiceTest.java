package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RacingGameServiceTest {
    private static final String CAR_OUTPUT_PATTERN = " : (-+)?";
    private RacingGameService racingGameService;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        racingGameService = new RacingGameService(outputView);
    }

    @Test
    @DisplayName("각 라운드에서 0부터 9까지의 숫자가 무작위로 생성되는지 테스트")
    void test_CarMovesForward() {

        int roundCount = 3;
        List<Car> cars = Arrays.asList(new Car("Car1"), new Car("Car2"));


        for (int i = 0; i < roundCount; i++) {
            racingGameService.playRound(cars);
            System.out.println("<ROUND " + i + ">");
            for (Car car : cars) {
                assertTrue(car.getPosition() >= 0 && car.getPosition() <= 9);
                System.out.println("Car : " + car.getName() + " Position : " + car.getPosition());
            }
        }
    }

    @ParameterizedTest
    @MethodSource("provideRandomValues")
    @DisplayName("생성된 숫자에 따라 자동차가 전진하거나 멈추는지 확인하는 테스트")
    void testCarMovementBasedOnRandomValue(int randomValue, int expectedPosition) {
        Car car = new Car("testCar");
        if (randomValue >= 4) {
            car.move();
        }
        assertEquals(expectedPosition, car.getPosition());
    }

    static Stream<Arguments> provideRandomValues() {
        return Stream.of(
                Arguments.arguments(4, 1),
                Arguments.arguments(5, 1),
                Arguments.arguments(6, 1),
                Arguments.arguments(3, 0),
                Arguments.arguments(2, 0),
                Arguments.arguments(1, 0)
        );
    }

    @Test
    @DisplayName("자동차 이름과 -로 표시된 전진 결과가 올바르게 출력되는지 테스트")
    void testPrintResult() {

        int attemptCount = 5;
        List<Car> cars = Arrays.asList(new Car("SONATA"), new Car("ABANTE"));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        try {

            racingGameService.raceGame(cars, attemptCount);

            String output = outputStreamCaptor.toString();

            for (Car car : cars) {
                assertTrue(output.contains(car.getName() + " : "));
                assertTrue(output.contains("SONATA") || output.contains("ABANTE"));
                String regex = car.getName() + CAR_OUTPUT_PATTERN;
                assertTrue(output.matches("(?s).*" + regex + ".*"));
            }
        } finally {
            System.setOut(System.out);
        }
    }

    @ParameterizedTest
    @MethodSource("provideCarsForWinnerTests")
    @DisplayName("전진한 거리에 따른 우승자 검증 테스트")
    void testFindWinners(List<Car> cars, List<String> expectedWinners) {
        List<String> winners = racingGameService.findWinners(cars);
        assertEquals(expectedWinners.size(), winners.size());
        assertTrue(winners.containsAll(expectedWinners));
    }

    static Stream<Arguments> provideCarsForWinnerTests() {
        return Stream.of(
                Arguments.arguments(createCarsWithMovement("Car1"), Arrays.asList("Car1")),
                Arguments.arguments(createCarsWithMovement("Car1", "Car2", "Car3"), Arrays.asList("Car1", "Car2", "Car3")),
                Arguments.arguments(createCarsWithMovement("Car1", "Car2"), Arrays.asList("Car1", "Car2"))
        );
    }

    private static List<Car> createCarsWithMovement(String... carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .toList();

        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

}
