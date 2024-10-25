package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @Test
    @DisplayName("Cars 생성 테스트")
    void carsCreationTest() {
        //given
        Cars cars = Cars.from(List.of("Car1", "Car2", "Car3"));
        List<Car> carList = cars.getCars();

        //when

        //then
        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0).getCarName()).isEqualTo("Car1");
        assertThat(carList.get(1).getCarName()).isEqualTo("Car2");
        assertThat(carList.get(2).getCarName()).isEqualTo("Car3");
    }

    @Test
    @DisplayName("단독 우승자 출력 테스트")
    void oneCarWinnerTest() {
        //given
        Car car1 = new Car("Car1",1);
        Car car2 = new Car("Car2",2);
        Car car3 = new Car("Car3",3);
        Cars cars1 = new Cars(List.of(car1,car2,car3));

        //when
        List<Car> winner = cars1.getWinners();

        //then
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getCarName()).isEqualTo("Car3");
    }

    @Test
    @DisplayName("다수 우승자 출력 테스트")
    void multipleCarWinnerTest() {
        //given
        Car car1 = new Car("Car1",1);
        Car car2 = new Car("Car2",3);
        Car car3 = new Car("Car3",3);
        Car car4 = new Car("Car4",2);
        Cars cars1 = new Cars(List.of(car1,car2,car3,car4));

        //when
        List<Car> winners = cars1.getWinners();

        //then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getCarName()).isEqualTo("Car2");
        assertThat(winners.get(1).getCarName()).isEqualTo("Car3");
    }
}