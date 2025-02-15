package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

@DisplayName("CarGameService 테스트")
public class CarGameServiceTest {

    private CarGameService carGameService;

    @BeforeEach
    public void setup() {
        this.carGameService = new CarGameService();
    }

    @Test
    void 숫자가_4이상이_나오면_자동차를_전진시킨다() {
        //given
        Car car = new Car("pobi");

        //when
        carGameService.checkAndMove(car, 4);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 모든_자동차에_대해_한_라운드를_진행한다() {
        //given
        Cars cars = new Cars(List.of(
            new Car("pobi"),
            new Car("woni")
        ));

        //when
        Cars result = carGameService.processRound(cars);

        //then
        assertThat(result.getCar("pobi").getPosition()).isIn(0, 1);
        assertThat(result.getCar("woni").getPosition()).isIn(0, 1);
    }

    @Test
    void 가장_멀리_간_자동차들을_찾는다(){
        //given
        Cars cars = new Cars(List.of(
            new Car("pobi"),
            new Car("woni"),
            new Car("jun")
        ));
        cars.getCar("pobi").move();
        cars.getCar("woni").move();

        //when
        Cars result = carGameService.findWinners(cars);

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
