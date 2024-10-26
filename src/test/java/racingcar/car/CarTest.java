package racingcar.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    void move() {
        // given
        List<Integer> integers = List.of(1, 4, 5, 7, 3, 8);
        int expectedPosition = 4;

        // when
        for(int number:integers) testCar.move(number);

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
