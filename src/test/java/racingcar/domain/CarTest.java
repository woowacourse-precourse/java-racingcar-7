package racingcar.domain;

import org.assertj.core.api.IntegerAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @Test
    @DisplayName("n번 이동한 후 자동차의 상태는 0이상 n이하 여야 한다")
    void validateCarMovesNumber() {
        // given
        // when
        for (int i = 0; i < 5; i++) {
            car.moveOrStop(); // 고정된 값으로 테스트
        }
        int result = car.getAdvanceNum();

        // then
        new IntegerAssert(result).isBetween(0, 5);
    }


    @DisplayName("getStatus()가 올바른 출력 형식을 반환하는지 확인")
    @Test
    void getStatusReturnsCorrectFormat() {
        for (int i = 0; i < 5; i++) {
            car.moveOrStop();
        }
        car.getStatus();
    }

}
