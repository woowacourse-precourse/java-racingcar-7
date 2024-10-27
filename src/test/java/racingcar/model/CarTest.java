package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.test_data_generator.CarGenerator;

class CarTest {

    @DisplayName("자동차 경주 진행 기능 - 무작위 값이 4이상이면 자동차는 1만큼 이동한다.")
    @ParameterizedTest(name = "주어진 무작위 값이 {0}일때, 자동차는 {1}만큼 움직임")
    @CsvSource({"2,0", "3,0", "4,1", "5,1"})
    public void 자동차_이동시도_테스트(int randomNumber, int expectedMovedDistance) {
        Car car = new Car("car");
        assertRandomNumberInRangeTest(
                () -> {
                    car.attemptMove();
                    assertThat(car.getMovedDistance()).isEqualTo(expectedMovedDistance);
                },
                randomNumber
        );
    }

    @DisplayName("자동차 경주 진행 상황 출력 기능 - 자동차의 진행 상황을 문자열로 생성")
    @ParameterizedTest(name = "\"{1}\" 이 생성되는 경우")
    @MethodSource()
    public void 자동차_세부내요_출력(Car car, String expectedCarDetail) {
        String actualCarDetail = car.makeDetail();
        assertThat(actualCarDetail).isEqualTo(expectedCarDetail);
    }

    private static Stream<Arguments> 자동차_세부내요_출력() {
        return Stream.of(
                Arguments.of(CarGenerator.makeCar("rc1", 5), "rc1 : -----"),
                Arguments.of(CarGenerator.makeCar("rc2", 0), "rc2 : "),
                Arguments.of(CarGenerator.makeCar("rc3", 3), "rc3 : ---")
        );
    }
}