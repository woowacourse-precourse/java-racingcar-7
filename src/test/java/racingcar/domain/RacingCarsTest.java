package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    @Test
    void TDD_경주_자동차_2대_이상_성공() {
        //given
        String input = "pobi,woni";

        //when
        RacingCars racingCars = new RacingCars(input);

        //then
        assertThat(racingCars.getCars()).extracting(RacingCar::getName).containsExactly("pobi", "woni");
    }

    @Test
    void TDD_경주_자동차_2대_이상_조건_실패() {
        //given
        String input = "pobi";

        //when
        assertThatThrownBy(() -> new RacingCars(input).ready()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_경주_우승자_찾기() {
        //given
        String input = "pobi,woni";
        RacingCars racingCars = new RacingCars(input);

        racingCars.getCars().stream()
                .filter(car -> car.getName().equals("pobi"))
                .forEach(car -> car.move(4));

        //when
        LinkedList<RacingCar> winners = racingCars.getWinners();

        //then
        assertThat(winners).extracting(RacingCar::getName).containsExactly("pobi");
    }

    @Test
    void 경주_공동_우승자_찾기_2명() {
        //given
        String input = "pobi,woni,java";
        RacingCars racingCars = new RacingCars(input);

        racingCars.getCars().stream()
                .filter(car -> !car.getName().equals("java"))
                .forEach(car -> car.move(4));

        //when
        LinkedList<RacingCar> winners = racingCars.getWinners();

        //then
        assertThat(winners).extracting(RacingCar::getName).containsExactly("pobi", "woni");
    }

    @Test
    void 경주_공동_우승자_찾기_3명() {
        //given
        String input = "pobi,woni,java";
        RacingCars racingCars = new RacingCars(input);

        //when
        LinkedList<RacingCar> winners = racingCars.getWinners();

        //then
        assertThat(winners).extracting(RacingCar::getName).containsExactly("pobi", "woni", "java");
    }
}
