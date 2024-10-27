package racingcar.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private final Car testCar = new Car("test");

    @AfterEach
    void tearDown() {
        testCar.clearPosition();
    }
    @DisplayName("생성된 차의 초기 위치는 0이다.")
    @Test
    void getPosition() {
        // given
        int expectedPosition = 0;

        // when
        int testCarPosition = testCar.getPosition();

        // then
        assertThat(testCarPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("숫자가 4 이상일 경우 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 7, 8, 9})
    void moveOver4Number(int value) {
        // given
        int expectedPosition = 1;

        // when
        testCar.move(value);

        // then
        assertThat(testCar.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("숫자가 4 미만일 경우 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 0})
    void moveUnder4Number(int value) {
        // given
        int expectedPosition = 0;

        // when
        testCar.move(value);

        // then
        assertThat(testCar.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("이름을 생성자에 념겨주면 그 이름으로 차가 생성된다.")
    @Test
    void getName() {
        // given
        String expectedName = "test";

        // when
        String extractedName = testCar.getName();

        //then
        assertThat(extractedName).isEqualTo(expectedName);
    }
}
