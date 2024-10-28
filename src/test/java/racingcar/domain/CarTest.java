package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"''", "'pobipo'"})
    void 비어있거나_5글자초과면_예외처리(String name) {
        assertThatThrownBy(() -> new Car(name, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"'po bi'", "pobi!"})
    void 알파벳이나_숫자가_아닌_문자가_들어오면_예외처리(String name) {
        assertThatThrownBy(() -> new Car(name, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "3, 0"})
    @DisplayName("4이상의 숫자가 들어오면 차를 전진")
    void checkMove(int input, int excepted) {
        //given
        final Car car = new Car("car", 0);

        //when
        car.move(input);

        //then
        Assertions.assertThat(car.getMoveCount()).isEqualTo(excepted);
    }
}