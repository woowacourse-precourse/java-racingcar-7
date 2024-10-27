package racingcar.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 이름 분리 성공")
    @Test
    void parseCarNamesTest() {
        String rawCarNames = "pobi,woni";

        Cars cars = new Cars(rawCarNames);

        Assertions.assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.getCars().get(1).getName()).isEqualTo("woni");
    }

    @DisplayName("우승자 판별 성공")
    @Test
    void findWinnersTest() {
        Cars cars = new Cars("pobi,woni");

        cars.getCars().get(0).move();
        List<Car> winners = cars.findWinners();

        Assertions.assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }
}
