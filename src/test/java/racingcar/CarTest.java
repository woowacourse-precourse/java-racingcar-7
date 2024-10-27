package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static Car testCar = Car.from("pobi");

    @Test
    @DisplayName("자동차의 이름은 5자를 넘지 않는다")
    public void whenFiveMoreName_thenThrowException() {
        //when & then
        assertThrows(IllegalArgumentException.class, () -> Car.from("gyunho"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 10, Integer.MAX_VALUE})
    @DisplayName("숫자가 4이상일 때 전진한다")
    public void whenFourMoreNumber_thenCarMove(int num) {
        //given
        Car car = Car.from("pobi");

        //when
        int position = car.move(num);

        //then
        assertThat(position).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 0, -1, Integer.MIN_VALUE})
    @DisplayName("숫자가 3이하일 때 움직이지 않는다")
    public void whenLessThanFour_thenCarDoesNotMove(int num) {
        //given
        Car car = Car.from("pobi");

        //when
        int position = car.move(num);

        //then
        assertThat(position).isEqualTo(Car.NOT_MOVED);
    }

    @DisplayName("자동차의 이름과 위치를 함께 가진다")
    @RepeatedTest(value = 5, name = RepeatedTest.SHORT_DISPLAY_NAME)
    public void whenCarMoves_thenReturnsCarNameWithCorrectPosition(RepetitionInfo repetitionInfo) {
        //given
        String carName = "pobi";
        int position = repetitionInfo.getCurrentRepetition();
        int moveRole = 4;

        //when
        testCar.move(moveRole);

        //then
        assertThat(testCar.getNameWithPosition()).isEqualTo(carName + " : " + "-".repeat(position));
    }
}