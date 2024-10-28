package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class CarsTest {

    @Test
    @DisplayName("경주_우승자_계산_테스트")
    void calculateFinalWinner() {
        Car pobi = new Car("pobi");
        Car hani = new Car("hani");
        Car suzi = new Car("suzi");

        List<Car> carsList = List.of(pobi, hani, suzi);
        Cars cars = new Cars(carsList);

        pobi.move(5);
        pobi.move(6);
        pobi.move(5);
        pobi.move(8);

        hani.move(5);
        hani.move(5);
        hani.move(5);

        suzi.move(5);
        suzi.move(4);
        suzi.move(9);
        suzi.move(5);

        List<String> expectedWinners = List.of("pobi", "suzi");
        List<String> actualWinners = cars.calculateFinalWinner();
        assertThat(actualWinners).containsOnlyElementsOf(expectedWinners);
    }
}