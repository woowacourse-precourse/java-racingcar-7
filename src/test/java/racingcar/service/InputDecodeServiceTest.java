package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Car;

class InputDecodeServiceTest {

    private final InputDecodeService inputDecodeService = new InputDecodeService();

    @DisplayName("자동차 이름 입력 기능 - 쉼표(,)를 기준으로 n 대의 자동차 이름입력")
    @ParameterizedTest(name = "\"{0}\"를 입력했을 경우")
    @MethodSource()
    void n대의_자동차_이름_입력(String rawCarNames, List<Car> expectedCars) {
        List<Car> actualCars = inputDecodeService.decodeRawCarNames(rawCarNames);
        assertThat(actualCars)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyElementsOf(expectedCars);
    }

    private static Stream<Arguments> n대의_자동차_이름_입력() {
        return Stream.of(
                Arguments.of("car1,car2",
                        List.of(new Car("car1"), new Car("car2"))),
                Arguments.of("111,222,333",
                        List.of(new Car("111"), new Car("222"), new Car("333"))),
                Arguments.of("rc1,rc2,rc3,rc4",
                        List.of(new Car("rc1"), new Car("rc2"), new Car("rc3"), new Car("rc4")))
        );
    }

    @DisplayName("전진 시도 횟수 입력 기능 - 올바른 전진 시도 횟수 입력")
    @ParameterizedTest(name = "\"{0}\"를 입력했을 경우")
    @CsvSource({"5,5", "10,10", "15,15"})
    void 올바른_전진_시도_횟수_입력(String rawRoundCount, int expectedRoundCount) {
        int actualRoundCount = inputDecodeService.decodeRawRoundCount(rawRoundCount);
        assertThat(actualRoundCount).isEqualTo(expectedRoundCount);
    }
}