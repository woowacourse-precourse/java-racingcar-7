package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}