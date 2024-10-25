package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @Test
    @DisplayName("car목록과 각 car의 number를 입력하면 한 번 전진하거나 정지")
    void play_success() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");
        List<Integer> numbers = List.of(4, 3);
        Round.play(List.of(car1, car2), numbers);
        assertThat(car1.getDistance()).isEqualTo(1);
        assertThat(car2.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("car목록과 각 car의 number목록의 크기가 일치하지 않으면 예외")
    void play_numbersSizeMismatch() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");
        List<Integer> numbers = List.of(4, 3, 5);
        assertThatThrownBy(() -> Round.play(List.of(car1, car2), numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 컬렉션의 크기와 난수 컬렉션의 크기가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("한 round의 실행 결과 문자열 반환")
    void roundResult() {
        List<Car> cars = List.of(new Car("AAA"), new Car("BBB"));
        Round.play(cars, List.of(4, 3));
        String expectedResult = "AAA : -\nBBB : \n\n";
        assertThat(Round.roundResult(cars)).isEqualTo(expectedResult);
    }
}