package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class WinnerTest {

    @Test
    @DisplayName("이동횟수 pobi: 2, woni: 1, jun: 1으로 pobi가 우승한다")
    void test() {
        //given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.moveForward();
        pobi.moveForward();
        woni.moveForward();
        jun.moveForward();

        List<Car> cars = new ArrayList<>(List.of(pobi, woni, jun));
        Winner winner = new Winner();

        //when
        winner.addWinner(cars);
        List<Car> winners = winner.getWinners();

        //then
        assertThat(winners).hasSize(1)
                .containsExactlyInAnyOrder(pobi);
    }
}