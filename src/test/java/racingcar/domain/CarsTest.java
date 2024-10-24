package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private List<Car> carList;

    @BeforeEach
    void init() {
        carList = List.of(
                new Car("pobi"),
                new Car("jun"),
                new Car("Lim")
        );
    }

    @Test
    void 객체_생성_테스트() {

        //when
        Cars cars = new Cars(carList);

        //then
        assertThat(cars.getCars()).isEqualTo(carList);
    }

    @Test
    void 가장_멀리간_자동차() {
        //given
        Cars cars = new Cars(carList);

        //when
        List<Car> winners = cars.win();

        //then
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void 이동후_가장_멀리간_자동차() {
        //given
        Cars cars = new Cars(carList);
        cars.getCars().getFirst().process(5);

        //when
        List<Car> winners = cars.win();

        //then
        assertThat(winners.size()).isEqualTo(1);
    }
}
