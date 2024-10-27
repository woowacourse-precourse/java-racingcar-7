package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarServiceTest {
    @Test
    public void 자동차_이름_구분() {
        // given
        String carNamesInput = "pobi,woni,jun";
        RacingCarService service = new RacingCarService();

        // when
        List<Car> cars = service.separateCarNames(carNamesInput);

        // then
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    public void 자동차_랜덤_전진_테스트() {
        // given
        RacingCarService service = new RacingCarService() {
            @Override
            protected int getRandomNumber() {
                return 4;
            }
        };

        Car car = new Car("pobi");
        List<Car> cars = new ArrayList<>();
        cars.add(car);

        // when
        service.updateLocation(cars);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 자동차_랜덤_멈춤_테스트() {
        // given
        RacingCarService service = new RacingCarService() {
            @Override
            protected int getRandomNumber() {
                return 3;
            }
        };

        Car car = new Car("pobi");
        List<Car> cars = new ArrayList<>();
        cars.add(car);

        // when
        service.updateLocation(cars);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 우승자_판별_테스트() {
        // given
        RacingCarService service = new RacingCarService();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));

        cars.get(0).move();

        // when
        List<Car> winners = service.determineWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

}
