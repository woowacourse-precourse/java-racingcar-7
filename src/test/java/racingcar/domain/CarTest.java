package racingcar.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이동 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move(int moveCondition) {
        //given
        Car car = new Car("james");

        //when
        car.move(moveCondition);
        int position = car.getPosition();

        //then
        Assertions.assertThat(position).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차 정지 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    void carDoesNotMove(int moveCondition) {
        //given
        Car car = new Car("james");

        //when
        car.move(moveCondition);
        int position = car.getPosition();

        //then
        Assertions.assertThat(position).isEqualTo(0);
    }
}