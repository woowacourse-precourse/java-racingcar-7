package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        Cars cars = Cars.from(List.of("Car1", "Car2", "Car3"));

        //when
        AtomicInteger count = new AtomicInteger(0);
        cars.playOneRound(() -> {
            int callCount = count.getAndIncrement();
            return callCount == 2;
        });
        List<Car> winner = cars.getWinners();

        //then
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getCarName()).isEqualTo("Car3");
    }

    @Test
    @DisplayName("다수 우승자 출력 테스트")
    void multipleCarWinnerTest() {
        //given
        Cars cars = Cars.from(List.of("Car1", "Car2", "Car3", "Car4"));
        //when
        AtomicInteger count = new AtomicInteger(0);
        cars.playOneRound(() -> {
            int callCount = count.getAndIncrement();
            return (callCount == 1 || callCount == 2);
        });
        List<Car> winner = cars.getWinners();


        //then
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.get(0).getCarName()).isEqualTo("Car2");
        assertThat(winner.get(1).getCarName()).isEqualTo("Car3");
    }
}