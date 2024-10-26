package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class OptimizationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int WARMUP_ITERATIONS = 10;
    private static final int MAIN_ITERATIONS = 2000;

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("pobi,woni", "1", Arrays.asList("pobi", "woni")),
                Arguments.of("pobi,woni,jun", "3", Arrays.asList("pobi", "woni", "jun")),
                Arguments.of("car1,car2,car3,car4", "5", Arrays.asList("car1", "car2", "car3", "car4"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("다양한 케이스 실행 시간 측정")
    void checkMultipleCaseExecutionTime(String carNames, String rounds, List<String> expectedCars) {
        // Warm-up phase
        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            executeTestRun(carNames, rounds, expectedCars);
        }

        // Main measurement phase
        double totalElapsedTime = 0.0;
        for (int i = 0; i < MAIN_ITERATIONS; i++) {
            long startTime = System.nanoTime();
            executeTestRun(carNames, rounds, expectedCars);
            long endTime = System.nanoTime();
            totalElapsedTime += (endTime - startTime) / 1_000_000.0;
        }

        double averageElapsedTime = totalElapsedTime / MAIN_ITERATIONS;
        System.out.println(String.format(
                "Case: %s, Rounds: %s\nAverage Execution time over %d runs: %.2f ms\n",
                carNames, rounds, MAIN_ITERATIONS, averageElapsedTime
        ));
    }

    private void executeTestRun(String carNames, String rounds, List<String> expectedCars) {
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, rounds);

                    for (String car : expectedCars) {
                        Assertions.assertThat(output()).contains(car + " : ");
                    }

                    String output = output();
                    boolean hasWinner = expectedCars.stream()
                            .anyMatch(car -> output.contains("최종 우승자 : " + car));
                    Assertions.assertThat(hasWinner).isTrue();
                },
                MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("극단적인 케이스 테스트")
    void checkExtremeCaseTest() {
        String longCarNames = String.join(",",
                "car1", "car2", "car3", "car4", "car5",
                "car6", "car7", "car8", "car9", "car10"
        );
        String manyRounds = "30";
        List<String> expectedCars = Arrays.asList(
                "car1", "car2", "car3", "car4", "car5",
                "car6", "car7", "car8", "car9", "car10"
        );

        // Warm-up phase
        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            executeTestRun(longCarNames, manyRounds, expectedCars);
        }

        // Main measurement phase
        double totalElapsedTime = 0.0;
        for (int i = 0; i < MAIN_ITERATIONS; i++) {
            long startTime = System.nanoTime();
            executeTestRun(longCarNames, manyRounds, expectedCars);
            long endTime = System.nanoTime();
            totalElapsedTime += (endTime - startTime) / 1_000_000.0;
        }

        double averageElapsedTime = totalElapsedTime / MAIN_ITERATIONS;
        System.out.println(String.format(
                "Extreme Case - Many cars and rounds\nAverage Execution time over %d runs: %.2f ms",
                MAIN_ITERATIONS, averageElapsedTime
        ));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}