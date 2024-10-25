package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    String carName;
    Car car;

    @BeforeEach
    void setUp() {
        carName = "말동";
        car = new Car(carName);
    }

    @Test
    @DisplayName("이름 생성에 성공한다.")
    void createCarName() {
        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차의 위치가 0으로 초기화되어 생성된다.")
    void createCarPosition() {
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "wooteco"})
    @DisplayName("이름의 길이는 5글자 이하여야 한다.")
    void validateNameException(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 1~5글자 사이여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("자동차의 랜덤 넘버가 4이상일 때 전진한다.")
    void move(int movingNumber) {
        //when
        car.move(movingNumber);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("자동차의 랜덤 넘버가 4미만일 때 정지한다.")
    void notMove(int movingNumber) {
        //when
        car.move(movingNumber);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
