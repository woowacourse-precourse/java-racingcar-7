package racingcar.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import setup.TestCar;

class CarTest {

    private Car testCar;
    private static final String carName = "테스트카";

    @BeforeEach
    void setUp() {
        testCar = TestCar.getTestCar(carName);
    }

    @Test
    @DisplayName("이동 후 '-'이 하나 추가되어야 한다.")
    void move() {
        int beforePosition = testCar.getPosition();
        testCar.move();
        Assertions.assertThat(testCar.getPosition()).isEqualTo(1);
        Assertions.assertThat(beforePosition).isEqualTo(testCar.getPosition() - 1);
    }

    @Test
    @DisplayName("형식에 맞게 이름과 진행 상황이 표시되어야 한다.")
    void printStatus() {
        testCar.move();
        Assertions.assertThat(testCar.getProgress())
                .isEqualTo(carName + " : -\n");
    }

    @Test
    @DisplayName("자동차가 진전한 상태를 표시해야 한다.")
    void getPosition() {
        Assertions.assertThat(testCar.getStatus()).isEqualTo("");
        testCar.move();
        Assertions.assertThat(testCar.getStatus()).isEqualTo("-");
    }
}