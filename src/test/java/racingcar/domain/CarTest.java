package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;
    private static final String TEST_CAR_NAME = "pobi";

    @BeforeEach
    void setUp() {
        car = new Car(TEST_CAR_NAME);
    }

    @DisplayName("자동차 객체 생성시 위치는 0이다")
    @Test
    void carInitialPosition() {
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차 이름을 정상적으로 반환한다")
    @Test
    void getCarName() {
        assertThat(car.getName()).isEqualTo(TEST_CAR_NAME);
    }

    @DisplayName("4 이상의 값이 주어지면 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveForward(int number) {
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("3 이하의 값이 주어지면 정지한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stayPosition(int number) {
        car.move(number);
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("현재 위치만큼 하이픈을 생성한다")
    @Test
    void createMoveMark() {
        // given
        car.move(4); // position 1
        car.move(4); // position 2

        // when
        String moveMarks = car.getMoveHyphen();

        // then
        assertThat(moveMarks).isEqualTo("--");
    }
}
