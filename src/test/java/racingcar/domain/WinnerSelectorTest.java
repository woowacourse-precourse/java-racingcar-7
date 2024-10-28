package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerSelectorTest {

    @Test
    @DisplayName("전진 횟수에 따라 유일한 우승자가 선택된다.")
    void 유일한_우승자_선정 () {
        // given
        Car car1 = new Car("kim");
        Car car2 = new Car("glenn");
        List<Car> cars = List.of(car1, car2);

        car1.forward();
        car2.forward();
        car2.forward();

        // when
        List<String> winners = WinnerSelector.selectWinner(cars);

        // then
        assertEquals(1, winners.size());
        assertEquals("glenn", winners.getFirst());
    }

    @Test
    @DisplayName("전진 횟수에 따라 공동 우승자가 선택된다.")
    void 공동_우승자_선정 () {
        // given
        Car car1 = new Car("kim");
        Car car2 = new Car("glenn");
        List<Car> cars = List.of(car1, car2);

        car1.forward();
        car2.forward();

        // when
        List<String> winners = WinnerSelector.selectWinner(cars);

        // then
        assertEquals(2, winners.size());
        assertEquals("kim", winners.getFirst());
        assertEquals("glenn", winners.getLast());
    }

}