package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    Car car1, car2;
    List<Car> cars;
    Round round;

    @BeforeEach
    void beforeEach() {
        cars = Car.createInstances("AAA, BBB");
        car1 = cars.get(0);
        car2 = cars.get(1);
        round = new Round(cars);
    }

    @Test
    @DisplayName("car목록과 각 car의 number를 입력하면 한 번 전진하거나 정지")
    void play_success() {
        List<Integer> numbers = List.of(4, 3);
        round.play(numbers);
        assertThat(car1.getDistance()).isEqualTo(1);
        assertThat(car2.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("car목록과 각 car의 number목록의 크기가 일치하지 않으면 예외")
    void play_numbersSizeMismatch() {
        List<Integer> numbers = List.of(4, 3, 5);
        assertThatThrownBy(() -> round.play(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 컬렉션의 크기와 난수 컬렉션의 크기가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("한 round의 실행 결과 문자열 반환")
    void roundResult() {
        round.play(List.of(4, 3));
        String expectedResult = "AAA : -\nBBB : \n\n";
        assertThat(round.toString()).isEqualTo(expectedResult);
    }
}