package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @DisplayName("경주를 생성한다.")
    @Test
    void createRacing() {
        //given
        List<String> cars = createCars();
        int tryCount = 1;

        //when
        Racing racing = Racing.of(cars, tryCount);

        //then
        assertThat(racing).isEqualTo(Racing.of(cars, tryCount));
    }

    @DisplayName("경주가 가능하다면 true를 반환한다.")
    @Test
    void canRacing() {
        //given
        List<String> cars = createCars();
        int tryCount = 1;

        Racing racing = Racing.of(cars, tryCount);

        //when
        boolean result = racing.can();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("경주가 가능하지 않다면 false를 반환한다.")
    @Test
    void canNotRacing() {
        //given
        List<String> cars = createCars();
        int tryCount = 1;

        Racing racing = Racing.of(cars, tryCount);

        racing.deductTryCount();

        //when
        boolean result = racing.can();

        //then
        assertThat(result).isFalse();
    }

    private List<String> createCars() {
        return List.of("pobi", "woni", "jun");
    }
}